import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LogeshComponent } from './components/logesh/logesh.component';
import { VisakComponent } from './components/visak/visak.component';

const routes: Routes = [
  {path:'logesh', component:LogeshComponent},
  {path:'visak', component:VisakComponent},
  {path:'', redirectTo: "/logesh", pathMatch:"full"},
  {path:'**', redirectTo: "/visak", pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
