import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Checklist } from '../Beans/Checklist';

@Component({
  selector: 'app-add-check-list-dialog',
  templateUrl: './add-check-list-dialog.component.html',
  styleUrls: ['./add-check-list-dialog.component.css']
})
export class AddCheckListDialogComponent implements OnInit {

  checkList : Checklist;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  ngOnInit(): void {
    this.checkList = new Checklist(null,null,this.data['isPersonal']);
  }

  

}
