import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Observable, catchError, map, of } from 'rxjs';
import { BuildingFilter } from 'src/app/modals/BuildingFilter';
import { Building } from 'src/app/modals/building';
import { BuildingService } from 'src/app/services/building.service';
declare var google: any;

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomePageComponent implements OnInit{

  public buildings: Building[] = [];

  apiLoaded: Observable<boolean>;

 constructor(private service: BuildingService){}
  ngOnInit() {
    this.service.filterBuildings().subscribe(building=>{
      this.buildings = building;
      console.log(building);
    });
  }

  public searchFilter(filter: BuildingFilter){
    console.log("home", filter);
  }
  
}
