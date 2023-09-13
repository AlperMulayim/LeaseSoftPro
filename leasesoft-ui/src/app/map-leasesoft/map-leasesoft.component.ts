import { Component, Input, OnInit,OnChanges } from '@angular/core';
import { BuildingService } from '../services/building.service';
import { Building } from '../modals/building';

@Component({
  selector: 'app-map-leasesoft',
  templateUrl: './map-leasesoft.component.html',
  styleUrls: ['./map-leasesoft.component.scss']
})
export class MapLeasesoftComponent implements OnInit {

  @Input()
  public buildingList: Building[];

  constructor() { }

  ngOnInit(){
  }

  
  ngOnChanges() {

    console.log(this.buildingList);
    const myLatLng = { lat: -25.363, lng: 131.044 };
    const myLatLng2 = { lat: -25.563, lng: 131.044 };


    const map = new google.maps.Map(
      document.getElementById("map") as HTMLElement,
      {
        zoom: 4,
        center: myLatLng,
      }
    );

    new google.maps.Marker({
      position: myLatLng,
      map,
      title: "Hello World!",
    });

    // use a Material Icon as font
    new google.maps.Marker({
      position: myLatLng2,
      map,
      label: {
        text: "A", // codepoint from https://fonts.google.com/icons
        fontFamily: "Material Icons",
        color: "#ffffff",
        fontSize: "16px",
      },
      title: "Material Icon Font Marker",
    });

    this.buildingList.forEach(building => {
      new google.maps.Marker({
        position: { lat: building.lat, lng: building.lot },
        map,
        label: {
          text: building.id.toString(), // codepoint from https://fonts.google.com/icons
          fontFamily: "Material Icons",
          color: "#ffffff",
          fontSize: "16px",
        },
        title: "Material Icon Font Marker",
      });
    });
  }


   
}


