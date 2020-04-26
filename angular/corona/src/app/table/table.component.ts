import { Component, OnInit } from '@angular/core';
import { Statistics } from '../commons/stats.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  constructor(private http: HttpClient) { }

  currentStats:Array<Statistics>;
  world:Statistics;

  ngOnInit(): void {

    this.currentStats =  new Array();

    this.http.get<Array<Statistics>>('http://localhost:8080/stats/db')
    .subscribe( data =>{

      for(let d of data){
        if(d.country !== 'All')
        this.currentStats.push(d);
        else
        this.world = d;
      }

      this.world.country = 'World';

    });

    

  }

}
