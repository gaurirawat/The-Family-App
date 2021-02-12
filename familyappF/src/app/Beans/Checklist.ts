import { Family } from './Family';
import { Person } from './Person';

export class Checklist{
  constructor(
    public id: number,
    public name : String,
    public isPersonal : boolean,
  ){
  }
}