import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FileOtherOperationsComponent } from './Pages/file-other-operations/file-other-operations.component';
import { FileUploadComponent } from './Pages/file-upload/file-upload.component';
import { HomeComponent } from './Pages/home/home.component';
import { NavbarComponent } from './Pages/navbar/navbar.component';
import { FooterComponent } from './Pages/footer/footer.component';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FileUploadComponent,
    FileOtherOperationsComponent,
    HomeComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule, AppRoutingModule,
    Ng2SearchPipeModule, NgxPaginationModule,
    FormsModule, ReactiveFormsModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
