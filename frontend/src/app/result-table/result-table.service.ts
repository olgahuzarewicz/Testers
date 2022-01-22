import { Injectable } from '@angular/core';
import { Tester } from '../models/tester.model';

@Injectable({
  providedIn: 'root'
})
export class ResultTableService {
  testers: Tester[] = [{id: 1, name: 'A', surname: 'a', experience: 2}, 
  {id: 2, name: 'B', surname: 'b', experience: 3}, 
  {id: 3, name: 'C', surname: 'c', experience: 5}];
 

  constructor() { }

  getTesters(): Tester[]{
    return this.testers;
  }
}
