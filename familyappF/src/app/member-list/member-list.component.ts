import { Component, Input, OnInit } from '@angular/core';

const data = [
  {
    "name" : "Vaibhav Dodiya",
    "contactNo" : "9898989898"
  },
  {
    "name" : "Smit Limbani",
    "contactNo" : "9898989898"
  },
  {
    "name" : "Aishwarya Panikr",
    "contactNo" : "9898989898"
  },
];

@Component({
  selector: 'app-member-list',
  templateUrl: './member-list.component.html',
  styleUrls: ['./member-list.component.css']
})
export class MemberListComponent implements OnInit {

  @Input() familyId;
  members;
  constructor() { }

  ngOnInit(): void {
    console.log("fetch members from family id : ", this.familyId);

    this.members = data;
  }
}
