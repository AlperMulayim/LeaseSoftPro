import { Component, Input, OnInit } from '@angular/core';
import { Building } from '../modals/building';
import { BuildingService } from '../services/building.service';

@Component({
  selector: 'app-buildings-section',
  templateUrl: './buildings-section.component.html',
  styleUrls: ['./buildings-section.component.scss']
})
export class BuildingsSectionComponent implements OnInit {

  @Input()
  public buildingList: Building[]=[];

  constructor() { }

  ngOnInit() {
    
  }

}
