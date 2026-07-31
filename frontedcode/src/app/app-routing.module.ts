import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShopnowComponent } from './shopnow/shopnow.component';
import { RegistredComponent } from './registred/registred.component';
import { HomeComponent } from './home/home.component';
import { ProdcutdetailpageComponent } from './prodcutdetailpage/prodcutdetailpage.component';
import { LoginComponent } from './login/login.component';
import { FruitListComponent } from './fruit-list/fruit-list.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { AdminShopComponent } from './admin-shop/admin-shop.component';
import { AdminFruitComponent } from './admin-fruit/admin-fruit.component';
// Agar aapka folder name 'contactus' hai bina hyphen ke:
import { ContactusComponent } from './contactus/contactus.component'; 

const routes: Routes = [
  // 1. Default path (Jab app start ho)
  { path: '', redirectTo: 'shop', pathMatch: 'full' },

  // 2. User Pages
  { path: 'shop', component: ShopnowComponent },
  { path: 'home', component: ShopnowComponent }, 
  { path: 'register', component: RegistredComponent },
  { path: 'login', component: LoginComponent },
  { path: 'fruitlist', component: FruitListComponent },
  { path: 'cart', component: CartComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'product-details/:id', component: ProdcutdetailpageComponent },
  { path: 'contact-us', component: ContactusComponent },


  // 4. Admin Pages
  { path: 'admin/shops', component: AdminShopComponent },
  { path: 'admin/fruits/:shopId', component: AdminFruitComponent },

  // 5. Wildcard (Agar galat URL daale toh shop par le jaye)
  { path: '**', redirectTo: 'shop' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }