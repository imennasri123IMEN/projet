import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { InscriptionComponent } from './inscription/inscription.component';
import { ListComponent } from './list/list.component';



import { ModifierComponent } from './modifier/modifier.component';
import { ModifiermComponent } from './modifierm/modifierm.component';
import { MoyenComponent } from './moyen/moyen.component';
import { PayementComponent } from './payement/payement.component';

import { SupprimerComponent } from './supprimer/supprimer.component';
import { SupprimermComponent } from './supprimerm/supprimerm.component';




const routes: Routes = [
  {path:'inscription', component:InscriptionComponent},
  {path:'liste', component:ListComponent},
  {path:'moyent', component:MoyenComponent},
  {path:'supprimerm/:code', component:SupprimermComponent},
  {path:'modifierm/:code', component:ModifiermComponent},
  {path:'supprimer/:cin', component:SupprimerComponent},
  {path:'modifier/:cin', component:ModifierComponent},
  {path:'', component:ModifierComponent},
  {path:'payement', component:PayementComponent},
 
  {path:'supprimer', component:SupprimerComponent},
  {path:'', component:InscriptionComponent},
  


  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
