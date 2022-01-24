import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/homePage/home-page/home-page.component';
import { LoginPageComponent } from './pages/loginPage/login-page/login-page.component';
import { ProductPageComponent } from './pages/productPage/product-page/product-page.component';
import { ShoppingCartPageComponent } from './pages/shoppingCartPage/shopping-cart-page/shopping-cart-page.component';
import { SignupPageComponent } from './pages/signupPage/signup-page/signup-page.component';

const routes: Routes = [
  //{ path: '', redirectTo: '/', pathMatch: 'full' },
  { path: '', component: HomePageComponent },
  { path: 'signup', component: SignupPageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'products/:id', component: ProductPageComponent },
  { path: 'shopping', component: ShoppingCartPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
