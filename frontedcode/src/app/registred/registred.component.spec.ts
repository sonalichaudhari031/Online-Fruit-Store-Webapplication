import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistredComponent } from './registred.component';

describe('RegistredComponent', () => {
  let component: RegistredComponent;
  let fixture: ComponentFixture<RegistredComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegistredComponent]
    });
    fixture = TestBed.createComponent(RegistredComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
