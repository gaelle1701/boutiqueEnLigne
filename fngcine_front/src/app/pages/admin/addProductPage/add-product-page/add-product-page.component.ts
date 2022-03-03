import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Iproducts } from 'src/app/models/iproducts';
import { ProductService } from 'src/app/services/productService/product.service';


@Component({
  selector: 'app-add-product-page',
  templateUrl: './add-product-page.component.html',
  styleUrls: ['./add-product-page.component.scss']
})
export class AddProductPageComponent implements OnInit {
  addProductForm: FormGroup;
  submitted = false;
  isCreateMode: boolean;
  newProduct: any;
  id: number;
  productToModify: Iproducts | undefined;
  product: any;
  
  constructor(private productService: ProductService, private router: Router, private route: ActivatedRoute) {
    this.addProductForm = new FormGroup({});
    this.id = this.route.snapshot.params['id'];
    this.isCreateMode = !this.id;
  }



  ngOnInit(): void {
    let db = document.querySelector('#dp')?.innerHTML;
    console.log(db);
    
    this.initForm();
    this.productService.getProductById(this.id).subscribe(product => {
      this.product = product as Iproducts;
      db = this.product.releaseDate;
      console.log(db);
    })
  }

  initForm() {
    this.addProductForm = new FormGroup({
      name: new FormControl('', Validators.required),
      releaseDate: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      image: new FormControl('', Validators.required),
      genre: new FormControl('', Validators.required),
      price: new FormControl('', Validators.required),
      quantity: new FormControl('', Validators.required),
    })

    if (!this.isCreateMode) {
      console.log(document.querySelector('#dp')?.innerHTML);
      
      this.productService.getProductById(this.id).subscribe(product => {
        this.productToModify = product as Iproducts;
        console.log(product);

        this.addProductForm.setValue({
          name: this.productToModify.label,
          releaseDate: this.productToModify.releaseDate,
          description: this.productToModify.description,
          image: this.productToModify.urlImg,
          genre: this.productToModify.genre,
          price: this.productToModify.unitPrice,
          quantity: this.productToModify.qtyStock
        })
      });
    }
  }


  get form(): { [key: string]: AbstractControl } {
    return this.addProductForm.controls;
  }

  onSubmit() {
    console.log(this.addProductForm.value);
    let date = this.addProductForm.value.releaseDate.year + '-' + this.addProductForm.value.releaseDate.month + '-' + this.addProductForm.value.releaseDate.day;
    let releaseDate = formatDate(date, 'yyyy-MM-dd', 'fr-FR');
    
    this.newProduct = {
      label: this.addProductForm.value.name,
      releaseDate: releaseDate,
      description: this.addProductForm.value.description,
      urlImg: this.addProductForm.value.image,
      genre: this.addProductForm.value.genre,
      unitPrice: this.addProductForm.value.price,
      qtyStock: this.addProductForm.value.quantity,
    }

    this.productToModify = {
      id: this.id,
      label: this.addProductForm.value.name,
      releaseDate: releaseDate,
      description: this.addProductForm.value.description,
      urlImg: this.addProductForm.value.image,
      genre: this.addProductForm.value.genre,
      unitPrice: this.addProductForm.value.price,
      qtyStock: this.addProductForm.value.quantity,
    }

    console.log(this.productToModify);
    
    this.productService.createProduct(this.newProduct).subscribe((resp: any) => {
      console.log('Produit créé !');
      this.router.navigate(['admin-product']);
    })
  }
}
