import { Component, OnInit, HostListener } from '@angular/core';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'app-start-page',
  templateUrl: './start-page.component.html',
  styleUrls: ['./start-page.component.scss']
})
export class StartPageComponent implements OnInit {
  isShowCards:boolean = false;

  constructor(private spinnerService: Ng4LoadingSpinnerService) { }

  ngOnInit() {
    this.spinnerService.show();
    this.spinnerService.show();
    setTimeout(function () { this.spinnerService.hide() }.bind(this), 1500);
  }

  @HostListener("window:scroll", [])
  onWindowScroll() {
    let position = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
    let element = document.getElementById('startBudges');
    let positTop = element.getBoundingClientRect().top;
    let positBottom = element.getBoundingClientRect().bottom;
    if (position >= positTop && position <= positBottom) {
      this.isShowCards = true;
    } 
    // else
    // // this.isShowCards = false;
  }

}
