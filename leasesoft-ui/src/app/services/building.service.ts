import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Building } from '../modals/building';

@Injectable({
  providedIn: 'root'
})
export class BuildingService {

constructor(private http: HttpClient) { }

public getBuildings(): Observable<Building[]>{
  return this.http.get<Building[]>("api/v1/buildings");
}
}
