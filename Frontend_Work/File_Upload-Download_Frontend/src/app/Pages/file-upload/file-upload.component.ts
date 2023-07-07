import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-file-upload',
  templateUrl: './file-upload.component.html',
  styleUrls: ['./file-upload.component.css']
})
export class FileUploadComponent {

  constructor(private route: Router,
              private http: HttpClient, 
              private titleService: Title) { 
                  this.titleService.setTitle("File-Upload");
            }

  file: any;
  flag1: boolean = true;
  flag2: boolean = false;
  fileUploadURL = "http://localhost:8181/file/file-upload";

// =============================================================================

  selectFile(event: any) {
    console.log("File Choosed: ")
    console.log(event);
    this.file = event.target.files[0];
    console.log(this.file)
  }

  file_upload(): void {
    let formData = new FormData();
    formData.append("file",this.file);  //  here "file" is equal to backend @RequestParam("file")  

    this.flag1 = false;
    this.flag2 = true;
    this.http.post(this.fileUploadURL, formData).subscribe(
      (data: any)=>{
        console.log(data);
        alert(data.message);
        this.route.navigate(["file_other_operations"]);
        this.flag1 = true;
        this.flag2 = false;
      },
      (error)=>{
        console.log(error);
        alert("Error: File not uploaded or Maximum upload size exceeded...");
        this.flag1 = true;
        this.flag2 = false;
      },
    );
  }

// =============================================================================

  home_page() {
    this.route.navigate(['']);
  }

// ============================================================================= 
// =============================================================================

}
