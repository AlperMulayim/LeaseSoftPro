import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/homepage/homepage.component';
import { AboutPageComponent } from './pages/aboutpage/aboutpage.component';
import { NotFoundComponent } from './pages/notfound/notfound.component';

const routes: Routes = [
  {path:'',component:HomePageComponent},
  {path: 'home', component: HomePageComponent},
  {path:'about', component:AboutPageComponent},
  {path:'**',component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
