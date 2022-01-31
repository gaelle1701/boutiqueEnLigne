import { Component, OnInit } from '@angular/core';
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

  constructor(private deliveryService: DeliveryService) { }

  ngOnInit(): void {
    this.subDeliveries = this.deliveryService.subjDeliveries$.subscribe( deliveryDetails => {     
      this.deliveryDetails = deliveryDetails;
      console.log("deliveryDetails: ", this.deliveryDetails);
      
    })
    this.deliveryService.getListDeliveries();
  }

  ngOnDestroy(): void {
    this.subDeliveries.unsubscribe();
  }

}
