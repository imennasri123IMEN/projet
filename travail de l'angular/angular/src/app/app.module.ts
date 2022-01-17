import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import{FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ListComponent } from './list/list.component';
import { MoyenComponent } from './moyen/moyen.component';

import { SupprimerComponent } from './supprimer/supprimer.component';
import { ModifierComponent } from './modifier/modifier.component';
import { SupprimermComponent } from './supprimerm/supprimerm.component';
import { ModifiermComponent } from './modifierm/modifierm.component';
import { PayementComponent } from './payement/payement.component';








@NgModule({
  declarations: [
    AppComponent,
    InscriptionComponent,
    ListComponent,
    MoyenComponent,
    
    SupprimerComponent,
    ModifierComponent,
    SupprimermComponent,
    ModifiermComponent,
    PayementComponent,
   
   
  
    
   
    
    
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
