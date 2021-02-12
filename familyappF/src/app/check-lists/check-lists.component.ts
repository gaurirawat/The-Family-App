import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddCheckListDialogComponent } from '../add-check-list-dialog/add-check-list-dialog.component';
import { NotificationService } from '../services/notification.service';
import {GlobalService} from '../global.service';
import {FamilyAppService} from '../family-app.service';

const data = [
  {
      "id": 1,
      "family": null,
      "createdBy": {
          "id": 1,
          "name": "Gauri",
          "dob": null,
          "sex": "FEMALE",
          "username": "gauri",
          "password": "gauri",
          "contactNo": "9999999999",
          "email": "gaurirawat97@gmail.com",
          "maritalStatus": "SINGLE",
          "alive": true,
          "availableForMarriage": false
      },
      "items": [
          {
              "id": 1,
              "description": "pen",
              "active": true
          },
          {
              "id": 2,
              "description": "pencil",
              "active": false
          },
          {
              "id": 5,
              "description": "notebook",
              "active": false
          },
          {
              "id": 7,
              "description": "book",
              "active": true
          },
          {
              "id": 8,
              "description": "novel",
              "active": true
          }
      ],
      "name": "stationery",
      "open": true,
      "personal": true
  },
  {
      "id": 2,
      "family": null,
      "createdBy": {
          "id": 1,
          "name": "a",
          "dob": null,
          "sex": "MALE",
          "username": "a",
          "password": "a",
          "contactNo": "9999999999",
          "email": "a@a.a",
          "maritalStatus": "SINGLE",
          "alive": true,
          "availableForMarriage": false
      },
      "items": [
          {
              "id": 3,
              "description": "burgers",
              "active": false
          },
          {
              "id": 4,
              "description": "biscuit",
              "active": true
          },
          {
              "id": 6,
              "description": "coke",
              "active": true
          },
          {
              "id": 9,
              "description": "cake",
              "active": true
          }
      ],
      "name": "party eatables",
      "open": true,
      "personal": true
  }
];

@Component({
  selector: 'app-check-lists',
  templateUrl: './check-lists.component.html',
  styleUrls: ['./check-lists.component.css']
})
export class CheckListsComponent implements OnInit {

  checkLists : any;
  person : any;
  constructor(
    private dialog: MatDialog,
    private notifier : NotificationService,
    private globalService: GlobalService,
    private familyAppService: FamilyAppService
  ) { }

  ngOnInit(): void {
    this.checkLists = data;
  }

  addCheckList(){
    const dialogRef = this.dialog.open(AddCheckListDialogComponent,{
      data : {
        isPersonal : true,
      },
      width: "300px",
    });
    dialogRef.afterClosed().subscribe( checkList => {
      if (!checkList || checkList == false) {
        this.notifier.showMessage("Action Aborted");
      }
      else {
        console.log(checkList);

        this.notifier.showError("Call DB to add, returned checkList needs to be added to the current list here.");
      }
    });
  }

}
