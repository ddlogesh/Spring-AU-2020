import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormComponent } from './components/form/form.component';
import { SubmitComponent } from './components/submit/submit.component';

const routes: Routes = [
  {path:'form', component:FormComponent},
  {path:'submit', component:SubmitComponent},
  {path:'', redirectTo: "/form", pathMatch:"full"},
  {path:'**', redirectTo: "/form", pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
