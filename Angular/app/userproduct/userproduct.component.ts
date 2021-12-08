import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart, HttpClientService, Product } from '../service/httpClient.service';



@Component({
  selector: 'app-userproduct',
  templateUrl: './userproduct.component.html',
  styleUrls: ['./userproduct.component.css']
})
export class UserproductComponent implements OnInit {
  products!: Product[];
  category: any;
  cart!:Cart[];

  constructor(private httpClientService: HttpClientService,
    private router:Router) { }

  ngOnInit(): void {
    this.httpClientService.getProducts().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response: Product[]) {
    this.products = response;
  }

  Search() {
    if (this.category == " ") {
      this.ngOnInit();
    } else {
      this.category == this.category
      this.products = this.products.filter(res => {
        return res.category.toLocaleLowerCase().match(this.category.toLocaleLowerCase());
      });
    }

  }


}



