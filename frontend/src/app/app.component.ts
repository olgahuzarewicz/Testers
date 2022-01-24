import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedCountries: string[] = [];
  selectedDevices: string[] = [];

  countrySelected(country: string[]){
    this.selectedCountries = country;
  }

  deviceSelected(device: string[]){
    this.selectedDevices = device;
  }
}
