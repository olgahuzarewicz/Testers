import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Device } from '../models/device.model';

@Injectable({
  providedIn: 'root'
})
export class SearchBarService {

  constructor(private httpClient: HttpClient) { }

  getCountries(): Observable<string[]>{
    return this.httpClient.get<string[]>(environment.REST_API_SERVER + '/countries')
  }

  getDevices(): Observable<Device[]>{
    return this.httpClient.get<Device[]>(environment.REST_API_SERVER + '/devices')
  }
}
