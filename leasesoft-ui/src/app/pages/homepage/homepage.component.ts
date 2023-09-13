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
public filter: BuildingFilter = new BuildingFilter();

 constructor(private service: BuildingService){}
  ngOnInit() {
    let defaultFilter: BuildingFilter = {
      priceFrom: 98000,
      beds: 3,
      priceTo :99000,
      sizeTo :160,
      sizeFrom : 100
    }
    this.service.filterBuildings(defaultFilter).subscribe(building=>{
      this.buildings = building;
      console.log(building);
    });
  }

  public searchFilter(filter: BuildingFilter){
    this.service.filterBuildings(filter).subscribe(building=>{
      this.buildings = building;
      console.log(building);
    });
    console.log("home", filter);
  }
  
}
