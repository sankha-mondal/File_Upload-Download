import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FileOtherOperationsComponent } from './Pages/file-other-operations/file-other-operations.component';
import { FileUploadComponent } from './Pages/file-upload/file-upload.component';
import { HomeComponent } from './Pages/home/home.component';

const routes: Routes = [
  { path:'', component: HomeComponent},
  { path:'file_upload', component: FileUploadComponent},
  { path:'file_other_operations', component: FileOtherOperationsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
