import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSelectionListChange } from '@angular/material/list';
import { AddItemDialogComponent } from '../add-item-dialog/add-item-dialog.component';
import { Item } from '../Beans/Item';
import { NotificationService } from '../services/notification.service';

@Component({
  selector: 'app-check-list',
  templateUrl: './check-list.component.html',
  styleUrls: ['./check-list.component.css']
})


export class CheckListComponent implements OnInit {

  @Input() data : any;
  checkList;

  constructor(
    private dialog: MatDialog,
    private notifier : NotificationService,
  ) { }

  ngOnInit(): void {
    this.checkList = this.data;
    console.log(this.checkList);

  }

  setActive(item : Item) {
    console.log(item);
  }

  setInactive(item : Item) {
    console.log(item);
  }

  selectionChanged($event : MatSelectionListChange) {
    let item : Item = $event.option.value;

    if ( $event.option.selected ) {
      this.setInactive(item);
    }
    else {
      this.setActive(item);
    }
  }

  addItemToCheckList( item : Item) {
    console.log("Call service!");
    this.checkList.items.push(item);
  }

  addItem() {
    const dialogRef = this.dialog.open(AddItemDialogComponent,{
      width: "300px",
    });
    dialogRef.afterClosed().subscribe( item => {

      if(!item || item == false){
        this.notifier.showError("Operation Aborted!")
      }
      else {
        this.addItemToCheckList(item);
      }
    });

  }
}
