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
import { DeliveryModePageComponent } from './pages/deliveryModePage/delivery-mode-page/delivery-mode-page.component';
import { HomePageComponent } from './pages/homePage/home-page/home-page.component';
import { LoginPageComponent } from './pages/loginPage/login-page/login-page.component';
import { NotFoundPageComponent } from './pages/notFoundPage/not-found-page/not-found-page.component';
import { ProductPageComponent } from './pages/productPage/product-page/product-page.component';
import { ShoppingCartPageComponent } from './pages/shoppingCartPage/shopping-cart-page/shopping-cart-page.component';
import { IconComponent } from './components/icon/icon.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SignupPageComponent } from './pages/signupPage/signup-page/signup-page.component';
import { ProductDetailComponent } from './components/productDetail/product-detail/product-detail.component';
import { ShoppingSummaryComponent } from './components/shoppingSummary/shopping-summary/shopping-summary.component';
import { ConfirmationPageComponent } from './pages/confirmation-page/confirmation-page.component';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from './auth/auth.interceptor';
import { LayoutAuthComponent } from './components/layout-auth/layout-auth.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { Placement as PopperPlacement, Options } from '@popperjs/core';
import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';

registerLocaleData(localeFr, 'fr');

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
    DeliveryModePageComponent,
    HomePageComponent,
    LoginPageComponent,
    NotFoundPageComponent,
    ProductPageComponent,
    ShoppingCartPageComponent,
    ProductDetailComponent,
    ShoppingSummaryComponent,
    IconComponent,
    SignupPageComponent,
    LayoutAuthComponent,
    ConfirmationPageComponent,
  ],
  imports: [
    NgbModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

