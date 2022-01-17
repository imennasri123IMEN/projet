import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { InfosService } from '../infos.service';
import { moyenstransports } from '../moyenstransports';

@Component({
  selector: 'app-modifierm',
  templateUrl: './modifierm.component.html',
  styleUrls: ['./modifierm.component.css']
})
export class ModifiermComponent implements OnInit {

m:moyenstransports;
  constructor(public ps:InfosService,public ar:ActivatedRoute) { 
    let code:number;
    this.ar.params.subscribe(
      data=>{code =data.code;}

    );
    this.ps.persistm(code).subscribe(
data=>{this.m =data;}
    );

  }
  modifier(f:NgForm){
    let ts=f.value['tempa'];
    let ta=f.value['temps'];
 
    if(ts!="" && ta!=""){
      this.m.temps=ts;
      this.m.tempa=ta;
      
      this.ps.modifiermoyen(this.m).subscribe(
data=> {alert('ajout  avec succce')},
error=>{alert('succe de  modification');}
      );
    }
    else
    alert("saisir tous les champs")
  }

  ngOnInit(): void {
  }

}
