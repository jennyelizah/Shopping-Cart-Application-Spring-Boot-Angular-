import { Component, OnInit } from '@angular/core';
import { HttpClientService, Product } from '../service/httpClient.service';



@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrls: ['./updateproduct.component.css']
})
export class UpdateproductComponent implements OnInit {
  product!: Product[];
  producttoupdate =
    {

      productId: 0,

      productType: "",

      productName: "",

      category: "",

      rating: 0,

      review: "",

      image: "",

      price: 0,

      description: "",

      specification: ""



    }


  constructor(private httpclient: HttpClientService) { }

  ngOnInit(): void {

  }

  // edit(product:any){
  //   this.producttoupdate=product
  // }
  // updateproduct(){
  //   this.httpclient.update(this.producttoupdate).subscribe(resp=>{
  //     console.log(resp)
  //   })
  // }
}
