import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddEventDialogComponent } from '../add-event-dialog/add-event-dialog.component';
import { NotificationService } from '../services/notification.service';

const data = [
  {
    "date" : "12-12-2019",
    "createdBy" : {
      "name" : "Gauri Rawar",
    },
    "description" : "Engagement of Aarohi and Rahul",
    "name" : "Engagement Party",
    "participants" : [
      {
        "name" : "Vaibhav Dodiya",
        "contactNo" : "9999999999"
      },
      {
        "name" : "Smit Limbani",
        "contactNo" : "9999999999"
      },
      {
        "name" : "Aishwarya Panikr",
        "contactNo" : "9999999999"
      },
      ]

  },
  {
    "date" : "12-12-2019",
    "createdBy" : {
      "name" : "Gauri Rawar",
    },
    "description" : "Third birthday of our youngest daughter Anika",
    "name" : "Peehu's birthday party",
    "participants" : [
      {
        "name" : "Vaibhav Dodiya",
        "contactNo" : "9999999999"
      },
      {
        "name" : "Smit Limbani",
        "contactNo" : "9999999999"
      },
      {
        "name" : "Aishwarya Panikr",
        "contactNo" : "9999999999"
      },
    ]

  }
]

const data2 = [
  {
    "id"  : 1,
    "name" : "my family",
    "description" : "home sweet home",
    "size" : 3,
  },
  {
    "id"  : 2,
    "name" : "mom's side",
    "description" : "Mon's side of the family",
    "size" : 3,
  },
  {
    "id"  : 3,
    "name" : "dad's side",
    "description" : "dad's side of the family",
    "size" : 3,
  }
]

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {

  events;

  constructor(
    private dialog: MatDialog,
    private notifier : NotificationService,
  ) { }

  ngOnInit(): void {
    this.events = data;
  }

  addEvent() {
    console.log("Update families parameter!");

    const dialogRef = this.dialog.open(AddEventDialogComponent,{
      data : {
        families : data2,
      },
      width: "500px",
    });
    dialogRef.afterClosed().subscribe( event => {
      if (!event || event == false) {
        this.notifier.showMessage("Action Aborted");
      }
      else {
        console.log(event);

        this.notifier.showError("Call DB to add, returned event needs to be added to the current list here!");
      }
    });

  }
}
