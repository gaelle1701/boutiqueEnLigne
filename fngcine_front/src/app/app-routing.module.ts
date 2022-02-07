import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductPageComponent } from './pages/admin/addProductPage/add-product-page/add-product-page.component';
import { AdminCustomerPageComponent } from './pages/admin/adminCustomerPage/admin-customer-page/admin-customer-page.component';
import { AdminHomePageComponent } from './pages/admin/adminHomePage/admin-home-page/admin-home-page.component';
import { AdminOrderPageComponent } from './pages/admin/adminOrderPage/admin-order-page/admin-order-page.component';
import { AdminProductPageComponent } from './pages/admin/adminProductPage/admin-product-page/admin-product-page.component';
import { DeliveryModePageComponent } from './pages/deliveryModePage/delivery-mode-page/delivery-mode-page.component';
import { HomePageComponent } from './pages/homePage/home-page/home-page.component';
import { LoginPageComponent } from './pages/loginPage/login-page/login-page.component';
import { ProductPageComponent } from './pages/productPage/product-page/product-page.component';
import { ShoppingCartPageComponent } from './pages/shoppingCartPage/shopping-cart-page/shopping-cart-page.component';
import { SignupPageComponent } from './pages/signupPage/signup-page/signup-page.component';

const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'products/:id', component: ProductPageComponent },
  { path: 'shopping', component: ShoppingCartPageComponent },
  { path: 'delivery-mode', component: DeliveryModePageComponent },
  { path: 'signup', component: SignupPageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'admin-home', component: AdminHomePageComponent },
  { path: 'admin-product', component: AdminProductPageComponent },
  { path: 'admin-order', component: AdminOrderPageComponent },
  { path: 'admin-customer', component: AdminCustomerPageComponent },
  { path: 'add-product', component: AddProductPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
