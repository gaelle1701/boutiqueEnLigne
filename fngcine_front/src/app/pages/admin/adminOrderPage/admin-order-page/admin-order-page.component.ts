import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Iorders } from 'src/app/models/iorders';
import { AuthService } from 'src/app/services/authService/auth.service';
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

  constructor(private orderService: OrderService, private router: Router, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.onGetOrders();
    this.orderService.getOrders();
    this.orderService.getOrdersDetailSession();
    console.log(this.orderService.getOrdersDetailSession());
  }

  onGetOrders() {
    
    this.orderSub = this.orderService.orderSubject$.subscribe(resp => {
      this.orders = resp;
      console.log(this.orders);
      for (let index = 0; index < this.orders.length; index++) {
        const element = this.orders[index];
        this.labels = this.labels = _.without(_.keys(element), "orderDetailList");
      }
    })
  }

  onGetKeys() {

  }

  ngOnDestroy() {
    this.orderSub?.unsubscribe();
  }

}
