import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCustomerPageComponent } from './admin-customer-page.component';

describe('AdminCustomerPageComponent', () => {
  let component: AdminCustomerPageComponent;
  let fixture: ComponentFixture<AdminCustomerPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCustomerPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminCustomerPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
