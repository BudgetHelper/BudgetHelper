import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalAddItemComponent } from './modal-add-item.component';

describe('ModalAddItemComponent', () => {
  let component: ModalAddItemComponent;
  let fixture: ComponentFixture<ModalAddItemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalAddItemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalAddItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
