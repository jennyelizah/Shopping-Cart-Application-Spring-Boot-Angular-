import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClientService, Profile } from '../service/httpClient.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profiles!: Profile[];

  constructor(
    private httpClient:HttpClientService,
    private router:Router

  ) { }

  ngOnInit(): void {
    this.httpClient.getProfiles().subscribe(
      response => this.handleSuccessfulResponse(response),
    );
  }

  handleSuccessfulResponse(response: Profile[]) {
      this.profiles = response;
  }

  public delete(id:number){
    let resp=this.httpClient.deleteprofile(id);
    resp.subscribe(data=>{this.ngOnInit();
                           alert("Profile deleted")});
   }
   public addProfile(){
    this.router.navigate(['addprofile']);
  }

}
