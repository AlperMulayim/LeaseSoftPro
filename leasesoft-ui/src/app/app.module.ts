import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientCardComponent } from './client-card/client-card.component';
import { HeaderComponent } from './header/header.component';
import { HomePageComponent } from './pages/homepage/homepage.component';
import { NotFoundComponent } from './pages/notfound/notfound.component';
import { AboutPageComponent } from './pages/aboutpage/aboutpage.component';


@NgModule({
  declarations: [		
      AppComponent,
      ClientCardComponent,
      HeaderComponent,
      HomePageComponent,
      NotFoundComponent,
      AboutPageComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
