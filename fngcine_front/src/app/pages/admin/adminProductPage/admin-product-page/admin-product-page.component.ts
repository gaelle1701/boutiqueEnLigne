import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Iproducts } from 'src/app/models/iproducts';
import { ProductService } from 'src/app/services/productService/product.service';
import * as _ from 'underscore';

@Component({
  selector: 'app-admin-product-page',
  templateUrl: './admin-product-page.component.html',
  styleUrls: ['./admin-product-page.component.scss']
})
export class AdminProductPageComponent implements OnInit, OnDestroy {
  public products!: Iproducts[];
  productSub?: Subscription;
  public labels?: string[];

  constructor(private productService: ProductService, private router: Router) { 
  }
  
  ngOnInit(): void {
    this.onGetProducts();
    this.productService.getListProducts();
  }

  onGetProducts() {
    this.productSub = this.productService.productSubject$.subscribe(resp => {
      this.products = resp;
      console.log(this.products);
      for (let index = 0; index < this.products.length; index++) {
        const element = this.products[index];
        this.labels = _.without(_.keys(element), "urlImg");
      }
    })
  }

  deleteProduct(productId: any) {
    this.productService.deleteRecipe(productId).subscribe(resp => {
      console.log('le produit  a bien été supprimé');
      this.productService.getListProducts();
    });
  }

  

  ngOnDestroy() {
    this.productSub?.unsubscribe();
  }
}
