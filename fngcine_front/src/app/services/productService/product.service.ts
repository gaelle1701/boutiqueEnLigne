import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Iproducts } from '../../models/iproducts';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  productSubject$ = new Subject<Iproducts[]>();

  constructor(private http: HttpClient) { }

  getListProducts():void {
    this.http.get<Iproducts[]>(`${environment.baseURL}/products`).subscribe(resp => {
      this.productSubject$.next(resp);
    })
  }

  getProductById(id: string): Observable<Iproducts> {    
    return this.http.get<Iproducts>(`${environment.baseURL}/products/${parseInt(id, 10)}`);
  }

}


