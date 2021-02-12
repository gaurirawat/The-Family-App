import {Component, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {NotificationService} from "../services/notification.service";
import {Task} from "protractor/built/taskScheduler";

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  @Input() data : any;
  task;

  constructor(
    private dialog: MatDialog,
    private notifier: NotificationService,
  ) {}


  ngOnInit(): void {
    this.task=this.data;
    console.log(this.task)
  }

}
