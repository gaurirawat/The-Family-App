import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Person} from './Beans/Person';
import {GlobalConstants} from './utils/GlobalConstants';

@Injectable({
  providedIn: 'root'
})
export class FamilyAppService {

  serverUrl = 'http://localhost:8010/';
  getPersonUrl = 'person/get';
  options = {responseType: 'json'};
  person :Person= new Person('gauri', 'gauri', 'password', 'email', 777, 'Female', null, 'no', false, true )
  constructor(private httpClient: HttpClient,
  ) {}

  //Below are sample API's that integrate backend and frontend working
  public getPerson(username:String , password:String ) {
    return this.httpClient.post(GlobalConstants.getPerson, {'username': username, 'password' : password} ,{responseType: 'text'});
  }

  public setPerson(person) {
    return this.httpClient.post(GlobalConstants.getPerson , {
      'name' : person.name, 'username': person, 'password' : person.password, 'contactNo': person.contactNo, 'email': person.email, 'sex' : 'MALE'}, {responseType: 'text'});
    // return of(this.person);
  }

}
