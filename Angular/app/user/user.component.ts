import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart, HttpClientService, Product } from '../service/httpClient.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  products!: Product[];
  cart!: Cart[];

  constructor(private httpClientService: HttpClientService,
    public router:Router) { }

  ngOnInit(): void {
    this.httpClientService.getProducts().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response: Product[]) {
    this.products = response;
  }

  public addCart(data: any) {
    console.log("runs")
    this.httpClientService.addtoCart(data).subscribe(resp => {
      console.log(resp);
      alert("product added");
    })
  }

  public showcart(){
    this.router.navigate(['/cart'])
  }
}
