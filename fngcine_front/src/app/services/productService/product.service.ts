import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
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

  getProductById(productId: number){    
    return this.http.get<Iproducts>(`${environment.baseURL}/products/${productId}`).pipe(
      catchError(error => of([]))
    )
  }

}


