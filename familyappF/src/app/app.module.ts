import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatTabsModule} from '@angular/material/tabs';
import {MatDividerModule} from '@angular/material/divider';
import {FormsModule} from '@angular/forms';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import { HomepageComponent } from './homepage/homepage.component';
import { HeaderComponent } from './header/header.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import {_MatMenuDirectivesModule, MatMenuModule} from '@angular/material/menu';
import { MatSnackBarModule} from '@angular/material/snack-bar';
import {HttpClientModule} from '@angular/common/http';
import { GroupsComponent } from './groups/groups.component';
import { TasksComponent } from './tasks/tasks.component';
import {MatExpansionModule} from '@angular/material/expansion';
import { CheckListComponent } from './check-list/check-list.component';
import { MatListModule } from '@angular/material/list';
import { AddItemDialogComponent } from './add-item-dialog/add-item-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { CheckListsComponent } from './check-lists/check-lists.component';
import { AddCheckListDialogComponent } from './add-check-list-dialog/add-check-list-dialog.component';
import { MatSelectModule } from '@angular/material/select';
import { FamilyComponent } from './family/family.component';
import { MemberListComponent } from './member-list/member-list.component';
import { FamilyCheckListsComponent } from './family-check-lists/family-check-lists.component';
import { FamiliesComponent } from './families/families.component';
import { EventComponent } from './event/event.component';
import { EventsComponent } from './events/events.component';
import { AddEventDialogComponent } from './add-event-dialog/add-event-dialog.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {TaskDialogComponent} from "./task-dialog/task-dialog.component";
import {TaskComponent} from "./task/task.component";
import { MatBadgeModule } from '@angular/material/badge';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomepageComponent,
    HeaderComponent,
    GroupsComponent,
    TasksComponent,
    CheckListComponent,
    AddItemDialogComponent,
    CheckListsComponent,
    AddCheckListDialogComponent,
    FamilyComponent,
    MemberListComponent,
    FamilyCheckListsComponent,
    FamiliesComponent,
    EventComponent,
    EventsComponent,
    AddEventDialogComponent,
    TaskDialogComponent,
    TaskComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatTabsModule,
    MatDividerModule,
    FormsModule,
    MatButtonToggleModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    _MatMenuDirectivesModule,
    MatMenuModule,
    MatSnackBarModule,
    HttpClientModule,
    MatExpansionModule,
    MatListModule,
    MatDialogModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatBadgeModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
