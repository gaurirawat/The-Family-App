import { Injectable } from '@angular/core';
import {Person} from './Beans/Person';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  public person;
  public isPersonSet : boolean = false;

  constructor() { }

  setPerson(person) {
    this.person = person;
    this.isPersonSet = true;
  }

  getPerson() : Person{
    return this.person;
  }

  resetPerson() {
    this.person = null;
    this.isPersonSet = false;
  }
}
