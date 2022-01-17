import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { InfosService } from '../infos.service';
import { utili } from '../utili';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
 


  private uri="http://localhost:8484/SchoolRest/transport/utilisateurs";
  utilis;
  
  Router: any;
    constructor(private http: HttpClient){
    this.http.get(this.uri).subscribe((data)=>{this.utilis=data});
    }
  
    
   
  
  ngOnInit(): void {
  }

}
