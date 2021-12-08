import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Product } from '../service/httpClient.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products!: Product[];

  status: string | undefined;

  constructor(
    private httpClientService: HttpClientService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.httpClientService.getProducts().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response: Product[]) {
    this.products = response;
  }

  public deleteProduct(id: number) {
    let resp = this.httpClientService.delete(id);
    resp.subscribe(data => {
      this.ngOnInit();
      alert("Product deleted")
    });
  }

  public updateProduct(id: number) {
    this.router.navigate(['updateproduct', id]);
  }

  public addProduct() {
    this.router.navigate(['addproduct']);
  }

}

