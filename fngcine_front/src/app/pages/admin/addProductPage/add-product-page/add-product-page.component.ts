import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
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
  
  constructor(private productService: ProductService, private router: Router, private route: ActivatedRoute) {
    this.addProductForm = new FormGroup({});
    this.id = this.route.snapshot.params['id'];
    this.isCreateMode = !this.id;
  }

  ngOnInit(): void {
    this.initForm();
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

    this.productService.createProduct(this.newProduct).subscribe((resp: any) => {
      console.log('Produit créé !');
      this.router.navigate(['admin-product']);
    })
  }
}
