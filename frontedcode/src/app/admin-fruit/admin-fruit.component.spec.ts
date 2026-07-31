import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminFruitComponent } from './admin-fruit.component';

describe('AdminFruitComponent', () => {
  let component: AdminFruitComponent;
  let fixture: ComponentFixture<AdminFruitComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminFruitComponent]
    });
    fixture = TestBed.createComponent(AdminFruitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
