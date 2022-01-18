import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/layout/header/header.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { ProductCardComponent } from './components/productCard/product-card/product-card.component';
import { AddProductPageComponent } from './pages/admin/addProductPage/add-product-page/add-product-page.component';
import { AdminCustomerPageComponent } from './pages/admin/adminCustomerPage/admin-customer-page/admin-customer-page.component';
import { AdminHomePageComponent } from './pages/admin/adminHomePage/admin-home-page/admin-home-page.component';
import { AdminOrderPageComponent } from './pages/admin/adminOrderPage/admin-order-page/admin-order-page.component';
import { AdminProductPageComponent } from './pages/admin/adminProductPage/admin-product-page/admin-product-page.component';
import { OrderDetailPageComponent } from './pages/admin/orderDetailPage/order-detail-page/order-detail-page.component';
import { DeliveryFormPageComponent } from './pages/deliveryFormPage/delivery-form-page/delivery-form-page.component';
import { DeliveryModePageComponent } from './pages/deliveryModePage/delivery-mode-page/delivery-mode-page.component';
import { HomePageComponent } from './pages/homePage/home-page/home-page.component';
import { LoginPageComponent } from './pages/loginPage/login-page/login-page.component';
import { NotFoundPageComponent } from './pages/notFoundPage/not-found-page/not-found-page.component';
import { ProductPageComponent } from './pages/productPage/product-page/product-page.component';
import { ShoppingCartPageComponent } from './pages/shoppingCartPage/shopping-cart-page/shopping-cart-page.component';
import { SingnupPageComponent } from './pages/signupPage/singnup-page/singnup-page.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ProductCardComponent,
    AddProductPageComponent,
    AdminCustomerPageComponent,
    AdminHomePageComponent,
    AdminOrderPageComponent,
    AdminProductPageComponent,
    OrderDetailPageComponent,
    DeliveryFormPageComponent,
    DeliveryModePageComponent,
    HomePageComponent,
    LoginPageComponent,
    NotFoundPageComponent,
    ProductPageComponent,
    ShoppingCartPageComponent,
    SingnupPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
