import { Component, OnInit } from '@angular/core';
import { Building } from '../modals/building';
import { BuildingService } from '../services/building.service';

@Component({
  selector: 'app-buildings-section',
  templateUrl: './buildings-section.component.html',
  styleUrls: ['./buildings-section.component.scss']
})
export class BuildingsSectionComponent implements OnInit {


  public buildingList: Building[]=[];

  constructor(private service: BuildingService) { }

  ngOnInit() {
    this.service.filterBuildings().subscribe(building=>{
      this.buildingList = building;
      console.log(building);
    });
  }

}
