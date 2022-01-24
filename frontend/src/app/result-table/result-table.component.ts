import { Component, Input, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Tester } from '../models/tester.model';
import { ResultTableService } from './result-table.service';

@Component({
  selector: 'app-result-table',
  templateUrl: './result-table.component.html',
  styleUrls: ['./result-table.component.css']
})
export class ResultTableComponent implements OnInit {

  @Input()
  countries: string[] = [];

  @Input()
  devices: string[] = [];

  displayedColumns: string[] = ['id', 'name', 'surname', 'experience'];
  testers: Observable<Tester[]> = of();

  constructor(private service: ResultTableService) { }

  ngOnInit(): void {
    this.testers = this.getTesters();
  }

  ngOnChanges() {
    this.testers = this.service.getTestersBy(this.countries, this.devices);
  }

  getTesters(): Observable<Tester[]> {
    return this.service.getTesters();
  }

}
