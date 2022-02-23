import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminAuthGuard } from './auth/admin-auth.guard';
import { AuthGuard } from './auth/auth.guard';
import { LayoutAuthComponent } from './components/layout-auth/layout-auth.component';
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

  { path: 'home', component: HomePageComponent },
  { path: 'signup', component: SignupPageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'products/:id', component: ProductPageComponent },
  { path: 'shopping', component: ShoppingCartPageComponent },
  { path: '', canActivate: [AuthGuard], component: LayoutAuthComponent, children: [
    { path: 'admin-home', canActivate: [AdminAuthGuard], component: AdminHomePageComponent },
    { path: 'delivery-mode', component: DeliveryModePageComponent },
    { path: 'admin-order', component: AdminOrderPageComponent },
    { path: 'admin-product', component: AdminProductPageComponent },
    { path: 'admin-customer', component: AdminCustomerPageComponent },
    { path: 'add-product', component: AddProductPageComponent },
    { path: 'add-product/:id', component: AddProductPageComponent },
    ]
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
