import { Component, OnInit } from '@angular/core';
import {Person} from '../Beans/Person';
import {FamilyAppService} from '../family-app.service';
import {GlobalService} from '../global.service';
import {AppRoutingModule} from '../app-routing.module';
import {Router} from '@angular/router';
import {MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  selectedIndex = 1;
  signIn: boolean = true;
  person : Person = new Person(null, null, null, null, null, null, null, null, false, true)
  receivedPerson = null;
  constructor(
               private familyAppService : FamilyAppService,
               private globalService: GlobalService,
               private router : Router,
               private snackBar: MatSnackBar,) { }

  ngOnInit(): void {
  }

  resetPerson() {
    this.signIn = !this.signIn;
    this.person = new Person(null, null, null, null, null, null, null, null, false, true);
  }

  submit() {
    console.log("submit");
    this.router.navigateByUrl('homepage');
    /*
    let dataReceived;
    if (this.signIn) {
      this.familyAppService.getPerson(this.person.username, this.person.password).subscribe(
        data => {
          if (data == null) {
            console.log('data is null');
            this.person.username = null;
            this.person.password = null;
            this.snackBar.open("Invalid credentials", "", {duration: 3000,});
          } else {
            this.receivedPerson = data;
          }
        },
        error => {
          this.person.username = null;
          this.person.password = null;
          this.snackBar.open("Internal Server Error", "", {duration: 3000,});
        },
        () => {
          console.log('completed');
          if (this.receivedPerson != null) {
            this.globalService.setPerson(this.receivedPerson);
            this.router.navigateByUrl('homepage');
          }
        }
      )

    }
    else {
      this.familyAppService.setPerson(this.person).subscribe(
        data => {
          this.receivedPerson = data;
        },
        error => {
          this.person.username = null;
          this.person.password = null;
          this.snackBar.open("Internal Server Error", "", {duration: 3000,});
        },
        () => {
          this.globalService.setPerson(this.receivedPerson);
          this.router.navigateByUrl('homepage');
        }
      )
    }
     */
  }
}
