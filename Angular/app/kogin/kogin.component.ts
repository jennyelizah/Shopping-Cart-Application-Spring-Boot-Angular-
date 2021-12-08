import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserAuthService } from '../auth_services/user-auth.service';
import { UserService } from '../auth_services/user.service';

@Component({
  selector: 'app-kogin',
  templateUrl: './kogin.component.html',
  styleUrls: ['./kogin.component.css']
})
export class KoginComponent implements OnInit {

  constructor(private userService: UserService,
    private userAuthService: UserAuthService,
    private router: Router) { }

  ngOnInit(): void {
  }

  login(loginForm: NgForm) {
    this.userService.login(loginForm.value).subscribe((response: any) => {
      this.userAuthService.setRoles(response.user.role);
      this.userAuthService.setToken(response.jwtToken);
      const role = response.user.role[0].roleName;
      if (role === 'admin') {
        this.router.navigate(['/admin'])
      } else {
        this.router.navigate(['/user'])
      }
    },
      (error) => {
        console.log(error)
      }
    );
  }

}
