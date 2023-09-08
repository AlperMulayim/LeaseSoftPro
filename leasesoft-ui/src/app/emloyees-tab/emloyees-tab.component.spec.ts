/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { EmloyeesTabComponent } from './emloyees-tab.component';

describe('EmloyeesTabComponent', () => {
  let component: EmloyeesTabComponent;
  let fixture: ComponentFixture<EmloyeesTabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmloyeesTabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmloyeesTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
