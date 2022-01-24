import { Component, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { MatOption } from '@angular/material/core';
import { MatSelect } from '@angular/material/select';
import { Observable, of } from 'rxjs';
import { Device } from '../models/device.model';
import { SearchBarService } from './search-bar.service';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {
  allCountriesSelected = false;
  allDevicesSelected = false;

  @ViewChild('countriesSelect')
  countriesSelect!: MatSelect;

  @ViewChild('devicesSelect')
  devicesSelect!: MatSelect;

  countries$: Observable<string[]> = of([]);
  devices$: Observable<Device[]> = of();

  selectedCountries: string[] = [];
  selectedDevices: string[] = [];

  @Output() emitSelectedCountries = new EventEmitter<string[]>();
  @Output() emitSelectedDevices = new EventEmitter<any>();

  constructor(private service: SearchBarService) {
  }

  ngOnInit(): void {
    this.countries$ = this.getCountries();
    this.countries$.subscribe(cou => {
      this.selectedCountries = cou;
    });
    this.allCountriesSelected = true;

    this.devices$ = this.getDevices();
    this.devices$.subscribe(devices => {
      devices.map(device => this.selectedDevices.push(device.id));
    });
    this.allDevicesSelected = true;
  }

  getCountries(): Observable<string[]> {
    return this.service.getCountries();
  }

  getDevices(): Observable<Device[]> {
    return this.service.getDevices();
  }

  toggleAllCountriesSelection() {
    if (this.allCountriesSelected) {
      this.countriesSelect.options.forEach((item: MatOption) => item.select());
      this.emitSelectedCountries.emit([]);
    } else {
      this.countriesSelect.options.forEach((item: MatOption) => item.deselect());
    }
    this.countriesSelect.close();
  }

  countryClick() {
    let newStatus = true;
    this.countriesSelect.options.forEach((item: MatOption) => {
      if (!item.selected) {
        newStatus = false;
      }
    });
    this.allCountriesSelected = newStatus;

    if (this.allCountriesSelected) {
      this.emitSelectedCountries.emit([]);
    }
    else {
      this.emitSelectedCountries.emit(this.selectedCountries);
    }
  }

  toggleAllDevicesSelection() {
    if (this.allDevicesSelected) {
      this.devicesSelect.options.forEach((item: MatOption) => item.select());
      this.emitSelectedDevices.emit([]);
    } else {
      this.devicesSelect.options.forEach((item: MatOption) => item.deselect());
    }
    this.devicesSelect.close();
  }

  deviceClick() {
    let newStatus = true;
    this.devicesSelect.options.forEach((item: MatOption) => {
      if (!item.selected) {
        newStatus = false;
      }
    });
    this.allDevicesSelected = newStatus;

    if (this.allDevicesSelected) {
      this.emitSelectedDevices.emit([]);
    }
    else {
      this.emitSelectedDevices.emit(this.selectedDevices);
    }
  }
}
