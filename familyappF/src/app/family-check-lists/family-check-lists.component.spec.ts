import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FamilyCheckListsComponent } from './family-check-lists.component';

describe('FamilyCheckListsComponent', () => {
  let component: FamilyCheckListsComponent;
  let fixture: ComponentFixture<FamilyCheckListsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FamilyCheckListsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FamilyCheckListsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
