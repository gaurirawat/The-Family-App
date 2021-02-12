import { Component, Input, OnInit } from '@angular/core';
import { Family } from '../Beans/Family';

const data = {
  "id"  : 1,
  "name" : "Family1",
  "description" : "description",
  "size" : 5,
}

@Component({
  selector: 'app-family',
  templateUrl: './family.component.html',
  styleUrls: ['./family.component.css']
})
export class FamilyComponent implements OnInit {

  expandableElement = null;
  @Input() family;

  constructor() { }

  ngOnInit(): void {
    console.log(this.family);
    
  }

  updateExpandableElement( value : string) {
    if ( this.expandableElement == value ) {
      this.expandableElement = null;
    }
    else {
      this.expandableElement = value;
    }
  }

}
