import { Component, OnInit } from '@angular/core';
import {AddCheckListDialogComponent} from "../add-check-list-dialog/add-check-list-dialog.component";
import {TaskDialogComponent} from "../task-dialog/task-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {NotificationService} from "../services/notification.service";

// const data = [
//   {
//     "name" : "task 1",
//     "category" : "shopping",
//     "date" : "12-02-2021",
//     "description" : "sdfkjadfjlsadjflsjdlfjadflkjsflksdfl sdlfkjsdakjf slnjflksad lksdjflja dskjfl lsdfjlksdj fjal "
//   },
//   {
//     "name" : "task 2",
//     "category" : "doctor",
//     "date" : "23-02-2021",
//     "description" : "sflksdfl sdlfkjsdakjf slnjflksad lksdjl lsdfj "
//   }
// ];

const data= [
  {
    "id": 1,
    "createdBy": {
      "id": 1,
      "families": [],
      "notifications": [],
      "checklists": [],
      "name": "a",
      "dob": null,
      "sex": "MALE",
      "username": "a",
      "password": "a",
      "contactNo": "1111111111",
      "email": "a",
      "maritalStatus": "SINGLE",
      "newNotifications": 0,
      "alive": true,
      "availableForMarriage": true
    },
    "participants": [],
    "name": "Shopping from Zara",
    "description": "Shopping from Zara",
    "date": "2021-02-10",
    "type": "TASK",
    "category": "SHOPPING"
  },
  {
    "id": 2,
    "createdBy": {
      "id": 1,
      "families": [],
      "notifications": [],
      "checklists": [],
      "name": "a",
      "dob": null,
      "sex": "MALE",
      "username": "a",
      "password": "a",
      "contactNo": "1111111111",
      "email": "a",
      "maritalStatus": "SINGLE",
      "newNotifications": 0,
      "alive": true,
      "availableForMarriage": true
    },
    "participants": [],
    "name": "b",
    "description": "bsadv",
    "date": "2021-02-10",
    "type": "TASK",
    "category": "DINING"
  },
  {
    "id": 3,
    "createdBy": {
      "id": 1,
      "families": [],
      "notifications": [],
      "checklists": [],
      "name": "a",
      "dob": null,
      "sex": "MALE",
      "username": "a",
      "password": "a",
      "contactNo": "1111111111",
      "email": "a",
      "maritalStatus": "SINGLE",
      "newNotifications": 0,
      "alive": true,
      "availableForMarriage": true
    },
    "participants": [],
    "name": "Dinner at The Palm Tree",
    "description": "Dinner at The Palm Tree",
    "date": "2021-02-10",
    "type": "TASK",
    "category": "DINING"
  }
]

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})

export class TasksComponent implements OnInit {

  tasks: any;

  constructor(
    private dialog: MatDialog,
    private notifier : NotificationService,
  ) { }

  ngOnInit(): void {
    this.tasks = data;
  }

  addTask() {
    const taskDialogRef=this.dialog.open(TaskDialogComponent, {
      width: "360px",
    });
    taskDialogRef.afterClosed().subscribe(task => {
      if(!task || task == false)
      {
        this.notifier.showMessage("Action Aborted")
      }
      else {
        console.log(task);

        this.notifier.showError("Call DB to add, returned task needs to be added to the current list here.");
      }
    });
  }
}
