import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InfosService } from '../infos.service';

@Component({
  selector: 'app-supprimerm',
  templateUrl: './supprimerm.component.html',
  styleUrls: ['./supprimerm.component.css']
})
export class SupprimermComponent implements OnInit {
  code:number;
  constructor(public ps:InfosService,public ar:ActivatedRoute) { 
    this.ar.params.subscribe(
data=>{this.code=data.code;}
    );
  }
annuler(){
  alert('operation annuler');
}
valider(){
  this.ps.deletem(this.code).subscribe(
    data =>{alert("suppression succe");},
    error=>{alert('suppretion succe');}
  );
}
  ngOnInit(): void {
  }

}
