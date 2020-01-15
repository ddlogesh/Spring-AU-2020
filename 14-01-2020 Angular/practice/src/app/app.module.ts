import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SessionDetailComponent } from './components/session-detail/session-detail.component';
import { VisakComponent } from './components/visak/visak.component';
import { LogeshComponent } from './components/logesh/logesh.component';
import { RouteOutletComponent } from './components/route-outlet/route-outlet.component';

@NgModule({
  declarations: [
    AppComponent,
    SessionDetailComponent,
    VisakComponent,
    LogeshComponent,
    RouteOutletComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
