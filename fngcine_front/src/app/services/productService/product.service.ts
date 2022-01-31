import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Iproducts } from '../../models/iproducts';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  API_URL = `${environment.baseURL}`;

  productSubject$ = new Subject<Iproducts[]>();

  constructor(private http: HttpClient) { }

  getProducts():void {
    this.http.get<Iproducts[]>(`${this.API_URL}/products`).subscribe(resp => {
      this.productSubject$.next(resp)
    })
  }
}
