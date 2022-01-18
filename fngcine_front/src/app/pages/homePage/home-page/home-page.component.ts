import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Iproducts } from 'src/app/models/iproducts';
import { ProductService } from 'src/app/services/productService/product.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {

  public productCards!: Iproducts[];
  public subProductCards: Subscription;
  // public productCards!: string[];

  constructor(private productService: ProductService) { 
    this.subProductCards = this.productService.subProductCards$.subscribe( res => {
      this.productCards = res;
    })
    this.productService.getListProducts();
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.subProductCards.unsubscribe();
  }

}
