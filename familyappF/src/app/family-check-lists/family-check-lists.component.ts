import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddCheckListDialogComponent } from '../add-check-list-dialog/add-check-list-dialog.component';
import { NotificationService } from '../services/notification.service';

const data = [
  {
      "id": 1,
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
      "name": "checklist1",
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
              "description": "eraser",
              "active": false
          },
          {
              "id": 4,
              "description": "color",
              "active": true
          },
          {
              "id": 6,
              "description": "notepad",
              "active": true
          },
          {
              "id": 9,
              "description": "glitter",
              "active": true
          }
      ],
      "name": "checklist2",
      "open": true,
      "personal": true
  }
];


@Component({
  selector: 'app-family-check-lists',
  templateUrl: './family-check-lists.component.html',
  styleUrls: ['./family-check-lists.component.css']
})
export class FamilyCheckListsComponent implements OnInit {

  @Input() familyId;
  checkLists : any;

  constructor(
    private dialog: MatDialog,
    private notifier : NotificationService,
  ) { }

  ngOnInit(): void {
    console.log("Find checkList from familyId : ",this.familyId);
    
    this.checkLists = data;
  }

  addCheckList(){
    console.log("Add to family");
    
    const dialogRef = this.dialog.open(AddCheckListDialogComponent,{
      data : {
        isPersonal : false,
        familyName : "change it with actual name!",
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
