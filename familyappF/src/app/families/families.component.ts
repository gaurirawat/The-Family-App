import { Component, OnInit } from '@angular/core';
import {GlobalService} from '../global.service';

const data = [
  {
    "id"  : 1,
    "name" : "My Family",
    "description" : "Home sweet home",
    "size" : 3,
  },
  {
    "id"  : 2,
    "name" : "Mom's Side",
    "description" : "Mom's side of the family",
    "size" : 3,
  },
  {
    "id"  : 3,
    "name" : "Dad's Side",
    "description" : "Dad's side of the family",
    "size" : 3,
  }
];

@Component({
  selector: 'app-families',
  templateUrl: './families.component.html',
  styleUrls: ['./families.component.css']
})
export class FamiliesComponent implements OnInit {

  families : any;

  constructor(private globalService:GlobalService) { }

  ngOnInit(): void {
    this.families = data;
    // this.families = this.globalService.getPerson()['families'];
  }

}
