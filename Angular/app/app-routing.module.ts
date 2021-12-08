import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddproductComponent } from './addproduct/addproduct.component';
import { AddprofileComponent } from './addprofile/addprofile.component';
import { AdminComponent } from './admin/admin.component';
import { CartComponent } from './cart/cart.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { KoginComponent } from './kogin/kogin.component';
import { PaymentComponent } from './payment/payment.component';
import { ProductComponent } from './product/product.component';
import { ProfileComponent } from './profile/profile.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './_auth/auth.guard';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'products', component: ProductComponent },
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard], data: { roles: ['admin'] } },
  { path: 'addproduct', component: AddproductComponent },
  { path: 'profiles', component: ProfileComponent },
  { path: 'addprofile', component: AddprofileComponent },
  { path: 'login', component: KoginComponent },
  { path: 'user', component: UserComponent, canActivate: [AuthGuard], data: { roles: ['user'] }},
  { path: 'forbidden', component: ForbiddenComponent },
  { path: 'header', component: HeaderComponent },
  { path: 'home', component: HomeComponent },
  { path: 'cart', component: CartComponent},
  {path:'payment',component: PaymentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }