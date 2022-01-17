import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { moyenstransports } from './moyenstransports';
import { utili } from './utili';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})


export class InfosService {
  [x: string]: any;
  cin:number;
  loginurl="http://localhost:8484/SchoolRest/transport/utilisateurs/login/";
  apiurl="http://localhost:8484/SchoolRest/transport/utilisateurs";
  api="http://localhost:8484/SchoolRest/transport/moyentransport";
  deleteUserUrl="http://localhost:8484/SchoolRest/transport/utilisateurs/"
  constructor(private http: HttpClient) { }
  persist(utili){
    return this.http.post<utili>(this.apiurl,utili);
  }
  persistt(utili){
    return this.http.put<utili>(this.apiurl,utili);
  }
  deleteutil(cin: number) {
    return this.http.delete<any>(this.deleteUserUrl + cin);
  } 
  deletem(code: number) {
    return this.http.delete<any>(this.api + code);
  } 
  signIn(user :utili){
    this.loggedUser = user.password;
    this.loggedUser = user.mail;
    this.isloggedIn = true;
    
    localStorage.setItem('loggedUser',this.loggedUser);
    localStorage.setItem('isloggedIn',String(this.isloggedIn));
    }
    
  

  getUserFromDB(email:string,password:String):Observable<utili>
{
const url = `${this.loginurl}/${email}/${password}`;
return this.http.get<utili>(url);
}


  persistm(moyenstransports){
    return this.http.post<moyenstransports>(this.api,moyenstransports);
  }
  getutili(cin:number){
    return this.http.get<utili>(this.apiurl+"/"+cin);
  }

  modifietutili(p:utili){
    return this.http.put(this.apiurl, p);
  }
  modifiermoyen(m:moyenstransports){
    return this.http.put(this.apiurl, m);
  }
  
}

