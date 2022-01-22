import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SearchBarService {

  countries: string[] = ['Germany', 'Poland', 'USA'];
  devices: string[] = ['iPhone 4', 'iPhone 6', 'Samsung', 'OnePlus 3'];

  constructor() { }

  getCountries(): string[]{
    return this.countries;
  }

  getDevices(): string[]{
    return this.devices;
  }
}
