import { Component, Input, OnInit } from '@angular/core';
import { Employee } from '../modals/Employee';

@Component({
  selector: 'app-employee-card',
  templateUrl: './employee-card.component.html',
  styleUrls: ['./employee-card.component.scss']
})
export class EmployeeCardComponent implements OnInit {

  @Input()
  public employee: Employee;

  constructor() {
    
   }

  ngOnInit() {
  }

}
