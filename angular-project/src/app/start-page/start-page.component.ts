import { Component, OnInit, HostListener } from '@angular/core';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'app-start-page',
  templateUrl: './start-page.component.html',
  styleUrls: ['./start-page.component.scss']
})
export class StartPageComponent implements OnInit {
  isShowCards: boolean = false;

  constructor(private spinnerService: Ng4LoadingSpinnerService) { }

  ngOnInit() {
    this.spinnerService.show();
    this.spinnerService.show();
    setTimeout(function () { this.spinnerService.hide() }.bind(this), 1500);
    this.addStyleStaticToElement();

  }

  addStyleStaticToElement() {
    let position = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
    let element = document.getElementById('startBudges');
    if (position > 0) {
      console.log('hjdf')
      element.style.position = 'static';
    }
  }

  @HostListener("window:scroll", [])
  onWindowScroll() {
    let position = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
    if (position > 5) this.isShowCards = true;
  }

}
