import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cart, HttpClientService } from '../service/httpClient.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  carts!: Cart[];
  totaldata:any;
  public totalprice=0;
  public values:any;

  constructor(private httpClientService: HttpClientService,
    private router:Router) { }

  ngOnInit(): void {
    this.httpClientService.getcart().subscribe(
      response => {
        this.handleSuccessfulResponse(response);
        this.totaldata=response
        this.findtotal(this.totaldata)
      })
  }

  handleSuccessfulResponse(response: Cart[]) {
    this.carts = response;
  }


  findtotal(data: any) {
    this.values = data
    for (let j = 0; j < data.length; j++) {
      this.totalprice += this.values[j].price
      console.log(this.totalprice)
    }

  }
  
  public paynow(){
    this.router.navigate(['/payment']);
  }
  



}
