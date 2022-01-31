import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Iorders } from 'src/app/models/iorders';
import { OrderService } from 'src/app/services/orderService/order.service';
import * as _ from 'underscore';

@Component({
  selector: 'app-admin-order-page',
  templateUrl: './admin-order-page.component.html',
  styleUrls: ['./admin-order-page.component.scss']
})
export class AdminOrderPageComponent implements OnInit {

  public orders!: Iorders[];
  orderSub?: Subscription;
  public labels?: string[];

  constructor(private orderService: OrderService, private router: Router) {
  }

  ngOnInit(): void {
    this.onGetOrders();
    this.orderService.getOrders();
  }

  onGetOrders() {
    this.orderSub = this.orderService.orderSubject$.subscribe(resp => {
      this.orders = resp;
      console.log(this.orders);
      for (let index = 0; index < this.orders.length; index++) {
        this.labels = _.keys(this.orders[index]);
      }
    })
  }

  onGetKeys() {

  }

  ngOnDestroy() {
    this.orderSub?.unsubscribe();
  }
}
