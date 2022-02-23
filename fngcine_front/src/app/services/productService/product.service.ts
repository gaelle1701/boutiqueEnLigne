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

  getListProducts(): void {
    this.http.get<Iproducts[]>(`${`${environment.baseURL}`}/products`).subscribe(resp => {
      this.productSubject$.next(resp)
    })
  }

  getProductById(productId: number) {
    return this.http.get<Iproducts>(`${`${environment.baseURL}`}/products/${productId}`).pipe(
      catchError(error => of([])))
  }

  createProduct(product: Iproducts) {
    return this.http.post<Iproducts>(`${`${environment.baseURL}`}/admin/products`, product).pipe(
      catchError(error => of([])))
  }

  deleteRecipe(productId: number) {
    return this.http.delete<Iproducts>(`${`${environment.baseURL}`}/admin/products/${productId}`).pipe(
      catchError(error => of([])))
  }

  updateRecipe(product: Iproducts, productId: number) {
    return this.http.put<Iproducts>(`${`${environment.baseURL}`}/admin/products/${productId}`, product).pipe(
      catchError(error => of([])))
  }
}


