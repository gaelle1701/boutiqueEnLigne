import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryModePageComponent } from './delivery-mode-page.component';

describe('DeliveryModePageComponent', () => {
  let component: DeliveryModePageComponent;
  let fixture: ComponentFixture<DeliveryModePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeliveryModePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeliveryModePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
