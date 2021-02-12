import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCheckListDialogComponent } from './add-check-list-dialog.component';

describe('AddCheckListDialogComponent', () => {
  let component: AddCheckListDialogComponent;
  let fixture: ComponentFixture<AddCheckListDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddCheckListDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCheckListDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
