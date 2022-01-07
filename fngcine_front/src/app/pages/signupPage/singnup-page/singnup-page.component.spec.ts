import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingnupPageComponent } from './singnup-page.component';

describe('SingnupPageComponent', () => {
  let component: SingnupPageComponent;
  let fixture: ComponentFixture<SingnupPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SingnupPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SingnupPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
