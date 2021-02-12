import {Component, Input, OnInit} from '@angular/core';
import {Activity} from "../Beans/Activity";

@Component({
  selector: 'app-task-dialog',
  templateUrl: './task-dialog.component.html',
  styleUrls: ['./task-dialog.component.css']
})
export class TaskDialogComponent implements OnInit {

  @Input() data : any;
  task;

  constructor() {}

  ngOnInit(): void {
    this.task=new Activity(null, null, null, null);
  }

}
