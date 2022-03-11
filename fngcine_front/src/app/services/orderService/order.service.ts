import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Iorders } from '../../models/iorders'

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  orderSubject$ = new Subject<Iorders[]>();

  constructor(private http: HttpClient) { }

  getOrders() {
    this.http.get<Iorders[]>(`${`${environment.baseURL}`}/orders?limit=5`).subscribe(resp => {
      this.orderSubject$.next(resp)
    })
  }
  getOrdersDetailSession() {
    this.http.get<Iorders[]>(`${`${environment.baseURL}`}/orders/order-detail-list`).subscribe(resp => {
      this.orderSubject$.next(resp)
    })
  }



}
