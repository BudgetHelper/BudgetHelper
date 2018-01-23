import { Component, OnInit, HostListener } from '@angular/core';
import { Ng4LoadingSpinnerService } from 'ng4-loading-spinner';

@Component({
  selector: 'app-start-page',
  templateUrl: './start-page.component.html',
  styleUrls: ['./start-page.component.scss']
})
export class StartPageComponent implements OnInit {
  isShowCards: boolean = false;
  photo = 'assets/image/nav_bg.jpg';
  isShow: boolean = false;

  constructor(private spinnerService: Ng4LoadingSpinnerService) { }

  ngOnInit() {
    this.spinnerService.show();
    this.spinnerService.show();
    setTimeout(function () { this.spinnerService.hide() }.bind(this), 1500);
    setTimeout(function () { this.isShowCards = true}.bind(this), 1000);
    
  }
  up(): any {
    function onEdit() {
      let t;
      let top = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
      if (top > 0) {
        window.scrollBy(0, -100);
        t = setTimeout(onEdit, 20);
      } else clearTimeout(t);
      return false;
    }
    return onEdit();
  }

  @HostListener("window:scroll", [])
  onWindowScroll() {
    let position = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop || 0;
    if (position > 10) {
      this.isShow = true;
      console.log(`true`)
    } else
      this.isShow = false;
  }

  

}
