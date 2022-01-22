import { Component, OnInit } from '@angular/core';
import { SearchBarService } from './search-bar.service';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {

  countries: string[] = [];
  devices: string[] = [];

  constructor(private service: SearchBarService) { }

  ngOnInit(): void {
    this.countries = this.getCountries();
    this.devices = this.getDevices();
  }

  getCountries(): string[]{
    return this.service.getCountries();
  }

  getDevices(): string[]{
    return this.service.getDevices();
  }

}
