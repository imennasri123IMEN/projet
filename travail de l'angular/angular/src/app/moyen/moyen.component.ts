import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-moyen',
  templateUrl: './moyen.component.html',
  styleUrls: ['./moyen.component.css']
})
export class MoyenComponent implements OnInit {
  
  private uri2="http://localhost:8484/SchoolRest/transport/moyenstransports";
  utilis;
  moyen;
    constructor(private http: HttpClient){
    this.http.get(this.uri2).subscribe((data)=>{this.moyen=data});
    }
  

  ngOnInit(): void {
  }

}
