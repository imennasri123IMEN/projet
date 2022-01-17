import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { InfosService } from '../infos.service';
import { utili } from '../utili';

@Component({
  selector: 'app-modifier',
  templateUrl: './modifier.component.html',
  styleUrls: ['./modifier.component.css']
})
export class ModifierComponent implements OnInit {
p:utili;
  constructor(public ps:InfosService,public ar:ActivatedRoute) { 
    let cin:number;
    this.ar.params.subscribe(
      data=>{cin =data.cin;}

    );
    this.ps.getutili(cin).subscribe(
data=>{this.p =data;}
    );

  }
  modifier(f:NgForm){
    let l=f.value['nom'];
    let e=f.value['mail'];
    let p=f.value['password'];
    let pe=f.value['prenom'];
    if(l!="" && e!=""){
      this.p.nom=l;
      this.p.prenom=pe;
      this.p.mail=e;
      this.p.password=p;
      this.ps.modifietutili(this.p).subscribe(
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
