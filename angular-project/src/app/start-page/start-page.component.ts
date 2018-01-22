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

  constructor(private spinnerService: Ng4LoadingSpinnerService) { }

  ngOnInit() {
    this.spinnerService.show();
    this.spinnerService.show();
    setTimeout(function () { this.spinnerService.hide() }.bind(this), 1500);
    setTimeout(function () { this.isShowCards = true}.bind(this), 1000);
    
  }

  

}
