import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { Ng4LoadingSpinnerModule } from 'ng4-loading-spinner';
import { ImageCropperComponent } from 'ng2-img-cropper';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { StartPageComponent } from './start-page/start-page.component';
import { ModalAddItemComponent } from './modal-add-item/modal-add-item.component';
import { CropperComponent } from './cropper/cropper.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    StartPageComponent,
    ModalAddItemComponent,
    ImageCropperComponent,
    CropperComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    Ng4LoadingSpinnerModule.forRoot(),
    NgbModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
