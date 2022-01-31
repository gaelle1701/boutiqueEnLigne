import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Iproducts } from 'src/app/models/iproducts';
import { ProductService } from 'src/app/services/productService/product.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.scss']
})
export class ProductPageComponent implements OnInit {

  public product!: Iproducts;
  
  constructor(private productService: ProductService, private actRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const routeParams = this.actRoute.snapshot.paramMap;

    const productId = routeParams.get('id')
    if (productId) {
      this.productService.getProductById(productId).subscribe( product => {
        this.product = product;
        console.log(this.product);
        
      }) 
    }

  }

}
