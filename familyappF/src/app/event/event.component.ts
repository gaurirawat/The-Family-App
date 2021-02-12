import { Component, Input, OnInit } from '@angular/core';

const data = {
  "date" : "12-12-2019",
  "createdBy" : {
    "name" : "Gauri Rawar",
  },
  "description" : "Engagement of Aarohi and Rahul",
  "name" : "Engagement Party",
  "participants" : [
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
  ]

}

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  expandableElement = null;
  @Input() event;

  constructor() { }

  ngOnInit(): void {
    console.log(this.event);

  }

  updateExpandableElement( value : string) {
    if ( this.expandableElement == value ) {
      this.expandableElement = null;
    }
    else {
      this.expandableElement = value;
    }
  }

}
