import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { InfosService } from '../infos.service';
import { utili } from '../utili';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

 
  uri="http://localhost:8484/SchoolRest/transport/utilisateurs";
    
  msgErreur;
  resultat;
  Utilis;
  
  constructor(private http: HttpClient,private infoservices:InfosService) { }
  verifier (f:NgForm) 
  { 
   
  let nom = f.value["nom"]; 
  let prenom = f.value["prenom"]; 
  let mail = f.value["mail"];
  let password = f.value["password"];
  
  if ( nom == "" || prenom == "" || mail == "" || password == ""  ) 
  { 
  this.msgErreur = "Merci de remplir tous les champs"; 
  } 
  else{
    this.msgErreur =null;
  
    let util = new utili(nom,prenom,mail,password);
    
        this.infoservices.persist(util)
        .subscribe((utili)=> {
           this.Utilis= [utili,this.Utilis];
         })
  alert("Etudiant ajouter avec succès ");
  
    }
    
  }
 
  




  ngOnInit(): void {
  }

}
