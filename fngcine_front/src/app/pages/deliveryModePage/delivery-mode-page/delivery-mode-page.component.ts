import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Idelivery } from 'src/app/models/idelivery';
import { DeliveryService } from 'src/app/services/deliveryService/delivery.service';

@Component({
  selector: 'app-delivery-mode-page',
  templateUrl: './delivery-mode-page.component.html',
  styleUrls: ['./delivery-mode-page.component.scss']
})
export class DeliveryModePageComponent implements OnInit {

  public deliveryDetails!: Idelivery[];
  public subDeliveries!: Subscription;
  addressForm: FormGroup;
  submitted = false;

  constructor(private deliveryService: DeliveryService) {
    this.addressForm = new FormGroup({});
   }

  ngOnInit(): void {
    this.getDeliveryDetails();
    this.initForm();
  }

  getDeliveryDetails() {
    this.subDeliveries = this.deliveryService.subjDeliveries$.subscribe( deliveryDetails => {     
      this.deliveryDetails = deliveryDetails;
      console.log("deliveryDetails: ", this.deliveryDetails);
      
    })
    this.deliveryService.getListDeliveries();
  }

  initForm() {
    this.addressForm = new FormGroup({
      receiver: new FormControl('',[Validators.required, Validators.minLength(2)]),
      address: new FormControl('',[Validators.required, Validators.minLength(2)]),
      zipCode: new FormControl('',[Validators.required, Validators.minLength(2)]),
      city: new FormControl('',[Validators.required, Validators.minLength(2)])
    })
  }

  get form(): { [key: string]: AbstractControl } {
    return this.addressForm.controls;
  }

  onSubmit() {

  }

  ngOnDestroy(): void {
    this.subDeliveries.unsubscribe();
    this.submitted = true;
  }

}
