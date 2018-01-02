import { Component, OnInit, HostListener } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
smallNavbar:boolean = false;
  constructor() { }

  ngOnInit() {
  }

  @HostListener("window:scroll", [])
  onWindowScroll() {
    let position = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
    let heightImg = document.getElementById('img-navbar').clientHeight;
    if (position > heightImg) {
      this.smallNavbar = true;
    }else
      this.smallNavbar = false;
  }

}
