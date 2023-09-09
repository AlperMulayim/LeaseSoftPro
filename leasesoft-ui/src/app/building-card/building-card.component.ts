import { Component, Input, OnInit } from '@angular/core';
import { Building } from '../modals/building';

@Component({
  selector: 'app-building-card',
  templateUrl: './building-card.component.html',
  styleUrls: ['./building-card.component.scss']
})
export class BuildingCardComponent implements OnInit {

  @Input()
  public building: Building;
  constructor() { }

  ngOnInit() {
  }

}
