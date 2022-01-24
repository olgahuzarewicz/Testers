import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Tester } from '../models/tester.model';

@Injectable({
  providedIn: 'root'
})
export class ResultTableService {

  constructor(private httpClient: HttpClient) { }

  getTesters(): Observable<Tester[]> {
    return this.httpClient.get<Tester[]>(environment.REST_API_SERVER + '/testers')
  }

  getTestersBy(countries: string[], devices: string[]): Observable<Tester[]> {
    let params = new HttpParams();

    if (countries !== undefined && countries.length > 0) {
        params = params.append('countries', countries.join(','));
    }

   if (devices !== undefined && devices.length > 0) {
        params = params.append('devices', devices.join(','));
    }

    return this.httpClient.get<Tester[]>(environment.REST_API_SERVER + '/testers', { params: params })
  }
}
