import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'; 
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common'; // 👈 Date pipe ke liye zaroori

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FruitListComponent } from './fruit-list/fruit-list.component';
import { ProdcutdetailpageComponent } from './prodcutdetailpage/prodcutdetailpage.component';
import { ShopnowComponent } from './shopnow/shopnow.component';
import { RegistredComponent } from './registred/registred.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { AdminShopComponent } from './admin-shop/admin-shop.component';
import { AdminFruitComponent } from './admin-fruit/admin-fruit.component';
import { ContactusComponent } from './contactus/contactus.component';

 

@NgModule({
  declarations: [
    AppComponent,
    FruitListComponent,
    ProdcutdetailpageComponent,
    ShopnowComponent,
    RegistredComponent,
    HomeComponent,
    AboutComponent,
    LoginComponent,
    CartComponent,
    CheckoutComponent,
    AdminShopComponent,
    AdminFruitComponent,
    ContactusComponent,
    
  ],
  imports: [
    BrowserModule,
    CommonModule,      // ✅ 'date' pipe aur 'ngIf' ke liye
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }