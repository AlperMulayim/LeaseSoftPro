import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientCardComponent } from './client-card/client-card.component';
import { HeaderComponent } from './header/header.component';
import { HomePageComponent } from './pages/homepage/homepage.component';
import { NotFoundComponent } from './pages/notfound/notfound.component';
import { AboutPageComponent } from './pages/aboutpage/aboutpage.component';
import { EmloyeesTabComponent } from './emloyees-tab/emloyees-tab.component';
import { EmployeeCardComponent } from './employee-card/employee-card.component';
import { FooterComponent } from './footer/footer.component';
import { BuildingsSectionComponent } from './buildings-section/buildings-section.component';
import { BuildingCardComponent } from './building-card/building-card.component';
import { MapLeasesoftComponent } from './map-leasesoft/map-leasesoft.component';
import { BuildingFilterPanelComponent } from './filter-panels/building-filter-panel/building-filter-panel.component';


@NgModule({
  declarations: [								
      AppComponent,
      ClientCardComponent,
      HeaderComponent,
      HomePageComponent,
      NotFoundComponent,
      AboutPageComponent,
      EmloyeesTabComponent,
      EmployeeCardComponent,
      FooterComponent,
      BuildingsSectionComponent,
      BuildingCardComponent,
      MapLeasesoftComponent,
      BuildingFilterPanelComponent
   ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
