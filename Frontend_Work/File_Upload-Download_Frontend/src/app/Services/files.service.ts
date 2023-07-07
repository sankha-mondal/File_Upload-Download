import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Files } from '../Interfaces/files';

@Injectable({
  providedIn: 'root'
})
export class FilesService {

    constructor(private http: HttpClient) { }

// ============================================================================================================================

  getAll_Files() : Observable<Files[]> {
    return this.http.get<Files[]>("http://localhost:8181/file/files-getAll");
  }

  delete_Files(id: string):Observable<string> {
    return this.http.delete("http://localhost:8181/file/file-delete/"+id,{responseType:"text"});
  }

}
