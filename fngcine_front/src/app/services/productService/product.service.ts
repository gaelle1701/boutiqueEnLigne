import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Iproducts } from 'src/app/models/iproducts';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  productSubject$ = new Subject<Iproducts[]>();
  subjProduct$ = new Subject<Iproducts>();

  constructor(private http: HttpClient) { }

  // getProducts(): Observable<Iproducts[]> {
  //   return this.http.get<Iproducts[]>(`${environment.baseURL}/products`)
  // }

  // getListProducts(): void {
  //   this.getProducts().subscribe(data => {
  //     this.subjProducts$.next(data);
  //     console.log("data getListProducts: ", data);
      
  //   })
  // }

  getListProducts():void {
    this.http.get<Iproducts[]>(`${environment.baseURL}/products`).subscribe(resp => {
      this.productSubject$.next(resp);
    })
  }

  getProductById(id: string): Observable<Iproducts> {    
    return this.http.get<Iproducts>(`${environment.baseURL}/products/${parseInt(id, 10)}`);
  }

}


