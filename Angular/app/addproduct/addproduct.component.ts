import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClientService } from '../service/httpClient.service';


@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {


  constructor(private httpClient: HttpClientService) {


  }

  ngOnInit(): void {



  }

  public addproduct(submitform: NgForm) {
    this.httpClient.add(submitform.value).subscribe((resp) => {
      console.log(resp)
      alert: "Product added"
    })

  }

}
