import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Observable, catchError, map, of } from 'rxjs';
declare var google: any;

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss']
})
export class HomePageComponent implements OnInit{

  apiLoaded: Observable<boolean>;

 constructor(){}
  ngOnInit() {}
  
}
