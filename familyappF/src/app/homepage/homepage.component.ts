import { Component, OnInit } from '@angular/core';
import {Person} from '../Beans/Person';

const data = {
  "id" : 1,
  "name" : "Vaibhav",
  "username" : "VDodiya14",
  "contactNo" : "8866532842",
  "email" : "Vaibhav.Dodiya@iiitb.org",
  "sex" : "Male",
  "newNotifications" : 3,
}

const data2 = [
  {
    "id" : 1,
    "person" : {
      "id" : 1,
      "name" : "Vaibhav",
    },
    "message" : "Notification---------1",
    "timestamp" : "12-12-2019",
    "notificationRead" : false,
  },
  {
    "id" : 2,
    "person" : {
      "id" : 1,
      "name" : "Vaibhav",
    },
    "message" : "Notification---------2",
    "timestamp" : "22-22-2029",
    "notificationRead" : false,
  },
  {
    "id" : 3,
    "person" : {
      "id" : 3,
      "name" : "Vaibhav",
    },
    "message" : "Notification---------3",
    "timestamp" : "32-32-2039",
    "notificationRead" : false,
  },
  {
    "id" : 4,
    "person" : {
      "id" : 4,
      "name" : "Vaibhav",
    },
    "message" : "Notification---------4",
    "timestamp" : "42-42-2049",
    "notificationRead" : true,
  },
  {
    "id" : 5,
    "person" : {
      "id" : 5,
      "name" : "Vaibhav",
    },
    "message" : "Notification---------5",
    "timestamp" : "52-52-2059",
    "notificationRead" : true,
  },
  {
    "id" : 6,
    "person" : {
      "id" : 6,
      "name" : "Vaibhav",
    },
    "message" : "Notification---------6",
    "timestamp" : "62-62-2069",
    "notificationRead" : true,
  }
]

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  selection : String = 'MyFamilies';
  user;
  notifications;

  constructor() { }

  ngOnInit(): void {
    this.user = data;
    this.notifications = data2;
  }

  selectionChange(selection : String) {
    this.selection = selection;
  }

  notificationRead() {
    this.user.newNotifications = 0;
    this.notifications.forEach(notification => {
      if (notification.notificationRead == true) {
        return;
      }
      notification.notificationRead = true;
    });
  }

  redirectHome() {
    this.selection = "MyFamilies";
  }

}
