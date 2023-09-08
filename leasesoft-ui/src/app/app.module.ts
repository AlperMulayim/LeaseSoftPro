import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientCardComponent } from './client-card/client-card.component';
import { HeaderComponent } from './header/header.component';
import { HomePageComponent } from './pages/homepage/homepage.component';
import { NotFoundComponent } from './pages/notfound/notfound.component';
import { AboutPageComponent } from './pages/aboutpage/aboutpage.component';
import { EmloyeesTabComponent } from './emloyees-tab/emloyees-tab.component';
import { EmployeeCardComponent } from './employee-card/employee-card.component';


@NgModule({
  declarations: [				
      AppComponent,
      ClientCardComponent,
      HeaderComponent,
      HomePageComponent,
      NotFoundComponent,
      AboutPageComponent,
      EmloyeesTabComponent,
      EmployeeCardComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
