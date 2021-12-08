import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClientService } from '../service/httpClient.service';


@Component({
  selector: 'app-addprofile',
  templateUrl: './addprofile.component.html',
  styleUrls: ['./addprofile.component.css']
})
export class AddprofileComponent implements OnInit {

  constructor(private http: HttpClientService) { }

  ngOnInit(): void {
  }

  public addprofile(Submitform: NgForm) {
    this.http.adduser(Submitform.value).subscribe((resp) => {
      console.log(resp)
      alert: "Profile added"
    })
  }

}