import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Building } from '../modals/building';

@Injectable({
  providedIn: 'root'
})
export class BuildingService {

  constructor(private http: HttpClient) { }

  public filterBuildings(): Observable<Building[]> {

    let filter = {
      beds: 3,
      priceFrom: 98000
    }
    const headers = { 'content-type': 'application/json' }

    let body = JSON.stringify({
      "priceFrom": 98000,
      "beds": 3,
      "priceTo": 99000,
      "sizeTo": 160
    });
    return this.http.post<Building[]>("api/v1/buildings", body, { headers: headers });
  }
}
