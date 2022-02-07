import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Idelivery } from 'src/app/models/idelivery';
import { Iproducts } from 'src/app/models/iproducts';
import { DeliveryService } from 'src/app/services/deliveryService/delivery.service';
import { ProductService } from 'src/app/services/productService/product.service';

@Component({
  selector: 'app-shopping-cart-page',
  templateUrl: './shopping-cart-page.component.html',
  styleUrls: ['./shopping-cart-page.component.scss']
})
export class ShoppingCartPageComponent implements OnInit {

  public productDetails!: Iproducts[];
  public subProducts!: Subscription;

  constructor(private productService: ProductService) { }

  // EN ATTENTE DE VOIR POUR UN VRAI PANIER!!!!!
  ngOnInit(): void {
    this.subProducts = this.productService.productSubject$.subscribe( productDetails => {
      this.productDetails = productDetails;
      console.log("productDetails: ", this.productDetails);
      
    })
    this.productService.getListProducts();
  }

  ngOnDestroy(): void {
    this.subProducts.unsubscribe();
  }

}
