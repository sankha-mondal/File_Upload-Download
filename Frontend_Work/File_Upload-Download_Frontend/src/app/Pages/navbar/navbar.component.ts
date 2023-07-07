import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  
  constructor(private route: Router) { }

// ========================================================================================

  home_page() {
    this.route.navigate([""]);
  }

  file_upload() {
      this.route.navigate(["file_upload"]);
  }

  file_other_operations() {
    this.route.navigate(["file_other_operations"]);
  }

//  ========================================================================================


}
