import { Component, OnInit } from '@angular/core';
import { Item } from '../Beans/Item';

@Component({
  selector: 'app-add-item-dialog',
  templateUrl: './add-item-dialog.component.html',
  styleUrls: ['./add-item-dialog.component.css']
})
export class AddItemDialogComponent implements OnInit {
  item : Item;
  constructor() { }

  ngOnInit(): void {
    this.item = new Item(null,null,true);
  }

}
