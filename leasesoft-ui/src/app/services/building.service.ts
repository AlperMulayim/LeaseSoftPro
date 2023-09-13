import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Building } from '../modals/building';
import { BuildingFilter } from '../modals/BuildingFilter';

@Injectable({
  providedIn: 'root'
})
export class BuildingService {

  constructor(private http: HttpClient) { }

  public filterBuildings(filter: BuildingFilter): Observable<Building[]> {

    const headers = { 'content-type': 'application/json' }

    let body = JSON.stringify(filter);
    return this.http.post<Building[]>("api/v1/buildings", body, { headers: headers });
  }
}
