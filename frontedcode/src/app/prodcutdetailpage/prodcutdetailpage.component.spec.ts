import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdcutdetailpageComponent } from './prodcutdetailpage.component';

describe('ProdcutdetailpageComponent', () => {
  let component: ProdcutdetailpageComponent;
  let fixture: ComponentFixture<ProdcutdetailpageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProdcutdetailpageComponent]
    });
    fixture = TestBed.createComponent(ProdcutdetailpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
