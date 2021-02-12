import { Component, OnInit } from '@angular/core';
import {GlobalService} from '../global.service';
import {Person} from '../Beans/Person';

@Component({
  selector: 'app-groups',
  templateUrl: './groups.component.html',
  styleUrls: ['./groups.component.css']
})
export class GroupsComponent implements OnInit {

  person;
  groups;
  constructor( private globalService: GlobalService) { }


  ngOnInit(): void {
    // this.person = this.globalService.getPerson();
    // this.groups = this.person['groups'];
  }


}
