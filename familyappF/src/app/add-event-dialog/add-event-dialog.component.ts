import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Activity } from '../Beans/Activity';

const data = [
  {
    "id"  : 1,
    "name" : "Peehu's birthday",
    "description" : "Third birthday of our youngest daughter Anika",
    "size" : 4,
  },
  {
    "id"  : 2,
    "name" : "Engagement",
    "description" : "Engagement ceremony of Rahul and Aarohi",
    "size" : 4,
  },
  {
    "id"  : 3,
    "name" : "Family dinner",
    "description" : "Lets get together for a nice family dinner the upcoming Sunday",
    "size" : 4,
  }
]

@Component({
  selector: 'app-add-event-dialog',
  templateUrl: './add-event-dialog.component.html',
  styleUrls: ['./add-event-dialog.component.css']
})
export class AddEventDialogComponent implements OnInit {

  event : Activity;
  familyId = null;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
    this.event = new Activity(null,null,null, null);
  }

}
