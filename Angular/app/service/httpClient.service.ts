import { Injectable } from '@angular/core';
import { HttpBackend, HttpClient } from '@angular/common/http';
import { Role } from '../Role';

export class Product {
  constructor(
    public productId: number,
    public productType: string,
    public productName: string,
    public category: string,
    public rating: number,
    public review: string,
    public image: string,
    public price: number,
    public description: string,
    public specification: string
  ) {
  }
}
export class Profile {
  constructor(
    public profileId: number,
    public fullName: string,
    public image: string,
    public emailId: string,
    public mobileNumber: number,
    public about: string,
    public dateOfbirth: string,
    public gender: string,
    public role: Set<Role>,
    public userName: string,
    public password: string,
    public address: string
  ) { }
}

export class Cart {
  constructor(
    public cartId: number,
    public productType: string,
    public productName: string,
    public category: string,
    public rating: number,
    public review: string,
    public image: string,
    public price: string,
    public description: string,
    public specification: string) { }
}


// This is a service class
@Injectable({
  providedIn: 'root'
})

export class HttpClientService {
  private customHttpClient: HttpClient;

  constructor(
    private httpClient: HttpClient,
    httpbackend: HttpBackend


  ) { this.customHttpClient = new HttpClient(httpbackend) }


  getProducts() {
    console.log('Test Call');
    return this.httpClient.get<Product[]>('http://localhost:9002/product/getproducts');
  }

  public delete(productId: number) {
    return this.httpClient.delete<Product>("http://localhost:9002/product/deleteproduct/" + productId);
  }

  public update(product: Product) {
    return this.httpClient.put<Product>("http://localhost:9002/product/updateproduct", product)
  }

  public add(product: any) {
    return this.httpClient.post<Product>("http://localhost:9002/product/addproducts/", product);
  }

  getProfiles() {
    console.log('Test Call');
    return this.httpClient.get<Profile[]>('http://localhost:9001/getprofiles');
  }

  public deleteprofile(profileId: number) {
    return this.httpClient.delete<Profile>("http://localhost:9001/deletedetails/" + profileId);
  }

  public adduser(profile: any) {
    return this.httpClient.post<Profile>("http://localhost:9001/registerNewUser/", profile);
  }
  public getcart() {
    console.log('Test Call');
    return this.customHttpClient.get<Cart[]>("http://localhost:9003/getproducts");
  }

  public addtoCart(cart:Cart) {
    return this.customHttpClient.post<Cart>("http://localhost:9003/add",cart);
  }

  public deleteCart(Id: number) {
    return this.httpClient.delete<Product>("http://localhost:9003/delete/" + Id)
  }





}