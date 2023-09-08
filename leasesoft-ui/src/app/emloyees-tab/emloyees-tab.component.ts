import { Component, OnInit } from '@angular/core';
import { Employee } from '../modals/Employee';
import { EmployeeService } from '../services/employee.service';

@Component({
  selector: 'app-emloyees-tab',
  templateUrl: './emloyees-tab.component.html',
  styleUrls: ['./emloyees-tab.component.scss']
})
export class EmloyeesTabComponent implements OnInit {

  employees: Employee[] = []
  constructor(employeeService: EmployeeService) {
      employeeService.getEmployees().subscribe(data=>{
        this.employees = data;
      });
  }

  ngOnInit() {
  }

}
