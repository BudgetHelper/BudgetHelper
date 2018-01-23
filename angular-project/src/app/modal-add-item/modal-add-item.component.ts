import { Component, OnInit } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal-add-item',
  templateUrl: './modal-add-item.component.html',
  styleUrls: ['./modal-add-item.component.scss']
})
export class ModalAddItemComponent implements OnInit {
  photo = 'assets/image/budget.jpg';
  constructor(private modalService: NgbModal) { }

  ngOnInit() {
  }
  open(content) {
    this.modalService.open(content, { size: 'lg', windowClass: 'dark-modal' });
  }

}
