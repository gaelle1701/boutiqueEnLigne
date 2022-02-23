import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Iproducts } from 'src/app/models/iproducts';
import { ProductService } from 'src/app/services/productService/product.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.scss']
})
export class ProductPageComponent implements OnInit {

  product!: any;
  id: any;
  constructor(private productService: ProductService, private actRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.actRoute.params.subscribe(
      (params: Params) => {
        this.id = +params['id'];
        console.log(this.id);

        this.productService.getProductById(this.id).subscribe(product => {
      console.log(product);
      
    this.product = product;

      })
    })

  }

}
