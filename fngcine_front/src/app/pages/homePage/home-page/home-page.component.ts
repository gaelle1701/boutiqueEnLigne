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
  public subProducts!: Subscription;

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.subProducts = this.productService.subjProducts$.subscribe( productCards => {
      this.productCards = productCards;
      
    })
    this.productService.getListProducts();
  }

  ngOnDestroy(): void {
    this.subProducts.unsubscribe();
  }

}
