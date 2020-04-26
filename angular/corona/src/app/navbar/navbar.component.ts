import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Country } from '../commons/country.model';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  countries:Array<string>;

constructor(private http: HttpClient) {

    this.http.get<Array<Country>>('http://localhost:8080/countries/db')
    .subscribe(data => {
     
      this.countries = new Array();
        for(let d of data){

         this.countries.push(d.country);
       
        }

    });

  

   }

  ngOnInit(): void {

   
  }

}
