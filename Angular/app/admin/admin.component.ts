import { Component, OnInit } from '@angular/core';
import { HttpClientService } from '../service/httpClient.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private httpClient: HttpClientService) { }

  ngOnInit(): void {
  }

}
