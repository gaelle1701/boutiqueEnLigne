import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Iproducts } from 'src/app/models/iproducts';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  subProductCards$ = new Subject<Iproducts[]>();

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Iproducts[]> {
    return this.http.get<Iproducts[]>(`${environment.baseURL}/products`)
  }

  getListProducts(): void {
    this.getProducts().subscribe(data => {
      this.subProductCards$.next(data);
      console.log("data getListProducts: ", data);
      
    })
  }
}


