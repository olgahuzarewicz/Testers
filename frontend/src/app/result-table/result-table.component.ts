import { Component, OnInit } from '@angular/core';
import { ResultTableService } from './result-table.service';
import { Tester } from '../models/tester.model';

@Component({
  selector: 'app-result-table',
  templateUrl: './result-table.component.html',
  styleUrls: ['./result-table.component.css']
})
export class ResultTableComponent implements OnInit {
  
  displayedColumns: string[] = ['id', 'name', 'surname', 'experience'];
  //testers: Tester[] = [];

  testers: Tester[] = [{id: 1, name: 'A', surname: 'a', experience: 2}, 
  {id: 2, name: 'B', surname: 'b', experience: 3}, 
  {id: 3, name: 'C', surname: 'c', experience: 5}];

  constructor(private service: ResultTableService) { }

  ngOnInit(): void {
  }

  getTesters(countries: string[], devices: string[]): Tester[]{
    return this.service.getTesters();
  }

}
