import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import { AdminComponent } from './admin/admin.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { ProfileComponent } from './profile/profile.component';
import { AddprofileComponent } from './addprofile/addprofile.component';
import { KoginComponent } from './kogin/kogin.component';
import { SignupComponent } from './signup/signup.component';
import { UserComponent } from './user/user.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { RouterModule } from '@angular/router';
import { AuthGuard } from './_auth/auth.guard';
import { AuthInterceptor } from './_auth/auth.interceptor';
import {UserService} from './auth_services/user.service';
import { UserproductComponent } from './userproduct/userproduct.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import { CartComponent } from './cart/cart.component';
import { PaymentComponent } from './payment/payment.component';






@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    AdminComponent,
    AddproductComponent,
    ProfileComponent,
    AddprofileComponent,
    KoginComponent,
    SignupComponent,
    UserComponent,
    ForbiddenComponent,
    HeaderComponent,
    HomeComponent,
    UserproductComponent,
    CartComponent,
    PaymentComponent,
    
 


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    Ng2SearchPipeModule,
    
  ],
  providers: [
    AuthGuard,
    {
      provide:HTTP_INTERCEPTORS,
       useClass:AuthInterceptor,
      multi:true
    },
    UserService
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
