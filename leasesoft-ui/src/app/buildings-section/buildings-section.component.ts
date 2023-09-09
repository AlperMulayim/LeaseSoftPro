import { Component, OnInit } from '@angular/core';
import { Building } from '../modals/building';

@Component({
  selector: 'app-buildings-section',
  templateUrl: './buildings-section.component.html',
  styleUrls: ['./buildings-section.component.scss']
})
export class BuildingsSectionComponent implements OnInit {


  public buildingList: Building[]= [
    {
      name: "Comfort Apt",
      price: 2500,
      address: "West Street",
      beds:3,
      baths:2,
      carSpaces:1,
      size:125,
      listingType: 'Mo',
      priceUnit: '$'
    },
    {
      name: "Comfort Apt",
      price: 2500,
      address: "West Street",
      beds:3,
      baths:2,
      carSpaces:1,
      size:125,
      listingType: 'Mo',
      priceUnit: '$'
    },
    {
      name: "Comfort Apt",
      price: 2500,
      address: "West Street",
      beds:3,
      baths:2,
      carSpaces:1,
      size:125,
      listingType: 'Mo',
      priceUnit: '$'
    },
    {
      name: "Comfort Apt",
      price: 2500,
      address: "West Street",
      beds:3,
      baths:2,
      carSpaces:1,
      size:125,
      listingType: 'Mo',
      priceUnit: '$'
    }
  ]
  constructor() { }

  ngOnInit() {
  }

}
