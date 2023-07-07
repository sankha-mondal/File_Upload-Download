import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { FilesService } from 'src/app/Services/files.service';

@Component({
  selector: 'app-file-other-operations',
  templateUrl: './file-other-operations.component.html',
  styleUrls: ['./file-other-operations.component.css']
})
export class FileOtherOperationsComponent implements OnInit {

  files_array: any;
  
  deleteMsg: string = "";
  searchText: string = "";
  date_time: string = "";

  pageNo: number = 1;
  count: number = 0;
  tableSize: number = 5;
  tableSizes: any = [5, 10, 15, 20];

  searchText_files: string = "";

  constructor(private fs: FilesService,
              private titleService: Title) { 
                      this.titleService.setTitle("File List");
              }
              
    ngOnInit(): void {
      this.getAll_Files();
    }

// ================================== :Retrieve Operation: ======================================

    getAll_Files(): void {
      this.fs.getAll_Files().subscribe(result=> {
        this.files_array=result;
        console.log("All data comming for profile compo...")
        console.log(result);   // details for all users
      }) 
    }

  //==================================== :Delete Operation: =======================================

  delete_Files(id: string): void {
    if(confirm("Are you sure..!?")) {
      this.fs.delete_Files(id).subscribe(result=> {
        this.deleteMsg=result;
        alert(this.deleteMsg);
      },error=>console.log(error),()=> {
        this.getAll_Files();
      })
    }
  }

//==================================== :Download Operation: =======================================

  download_files(id: string): void {
    let download_url = "http://localhost:8181/file/file-download/"+id;
    let url =  download_url;
    download_url = "";
    window.open(url, "");
  }

//  ============================================================================================================

  // ======================  : Table Size Controls : ===================

  on_table_data_change(event: any) {
    this.pageNo = event;
    this.getAll_Files();   // use for real time data load
  }

  //  =====================  : Page Number Controls : ===================

  on_table_size_change(event: any) {
    this.tableSize = event.target.value;
    this.pageNo = 1;
    // this.get_All_User();   // use for real time data load
  }

//  ============================================================================================================


}
