import { Component, OnInit, ViewChild } from '@angular/core';
import { ImageCropperComponent, CropperSettings, Bounds, ImageCropper } from 'ng2-img-cropper';

@Component({
  selector: 'app-cropper',
  templateUrl: './cropper.component.html',
  styleUrls: ['./cropper.component.scss']
})
export class CropperComponent implements OnInit {

  data: any;
  isUploadImage: boolean = false;
  isShowCropper: boolean = true;
  isHiddeCropper: boolean = false;
  event: any;
  isShowErrorPhoto = false;
  isValidSize: boolean = true;
  messageErrorPhoto = '';

  @ViewChild('cropper', undefined) cropper: ImageCropperComponent;
  cropperSettings: CropperSettings;


  constructor() {
    this.cropperSettings = new CropperSettings();
    this.cropperSettings.minWidth = this.cropperSettings.width / 2;
    this.cropperSettings.minHeight = this.cropperSettings.height / 2;
    this.cropperSettings.noFileInput = true;
    this.cropperSettings.cropperDrawSettings.strokeColor = 'rgba(255,255,255,1)';
    this.cropperSettings.cropperDrawSettings.strokeWidth = 2;
    this.data = {};
  }


  ngOnInit() {
    this.cropperSettings.width = 328;
    this.cropperSettings.height = 246.11;
    this.cropperSettings.croppedWidth = 328;
    this.cropperSettings.croppedHeight = 246.11;

  }

  validationPhotoType(file: File) {
    var getExtensionImage = file.type.split('/');
    var checkimg = getExtensionImage[1].toLowerCase();
    var extensionImage = ['jpg', 'png', 'PNG', 'JPG', 'jpeg', 'JPEG'];
    if (extensionImage.indexOf(checkimg) == -1) {
      this.messageErrorPhoto = 'Invalid image type. Valid type is: jpg, png, jpeg';
      this.isShowErrorPhoto = true;
      this.cropper.reset();
      return false;
    }
  }
  validationPhotoSize(image,width,height) {
    if (width < 259 || height < 194) {
      //TODO change img.onload=null 
      image.onload = null;
      image['src'] = 'data:image/gif;base64,R0lGODlhAQABisValidSizeisValidSizeACH5BAEKisValidSizeEALisValidSizeisValidSizeisValidSizeBisValidSizeEisValidSizeAICTAEAOw==';
      this.cropper.reset();
      this.messageErrorPhoto = 'Invalid image size (' + width + '*' + height + '). Valid size is: ' + 328 + '*' + 246.11;
      this.isShowErrorPhoto = true;
      return false;
    }
  }

  fileChangeListener(event) {
    this.isShowErrorPhoto = false;
    this.isValidSize = true;
    var image = new Image();
    var file: File = event.target.files[0];
    var myReader: FileReader = new FileReader();
    var that = this;
    myReader.onloadend = function (loadEvent: any) {
      that.validationPhotoType(file);
      image.src = loadEvent.target.result;
      image.onload = function () {
        let width = image.width;
        let height = image.height;
        that.validationPhotoSize(image, width, height);
        that.cropper.setImage(image);
        if (that.cropper.image) {
          that.isUploadImage = true;
        }
      };
    };
    that.event = event;
    if (file) {
      myReader.readAsDataURL(file);
    }
    if (!file && !this.isValidSize) {
      this.cropper.reset();
      return false;
    }
  }

  showCropper() {
    this.isShowCropper = !this.isShowCropper;
    this.isHiddeCropper = false;
    this.fileChangeListener(this.event);
  }

  hiddeCropper() {
    this.isHiddeCropper = true;
    this.isShowCropper = false;

  }

}
