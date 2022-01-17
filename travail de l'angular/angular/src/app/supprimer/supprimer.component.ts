import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { InfosService } from '../infos.service';

@Component({
  selector: 'app-supprimer',
  templateUrl: './supprimer.component.html',
  styleUrls: ['./supprimer.component.css']
})
export class SupprimerComponent implements OnInit {
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
