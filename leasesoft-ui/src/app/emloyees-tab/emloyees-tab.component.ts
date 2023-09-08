import { Component, OnInit } from '@angular/core';
import { Employee } from '../modals/Employee';

@Component({
  selector: 'app-emloyees-tab',
  templateUrl: './emloyees-tab.component.html',
  styleUrls: ['./emloyees-tab.component.scss']
})
export class EmloyeesTabComponent implements OnInit {

  employees: Employee[] = [
    {
      name:"Alper",
      surname: "Mulayim",
      jobTitle:"Manager"
    },
    {
      name:"Kate",
      surname: "Kates",
      jobTitle:"Senior Seller"
    }
  ]
  constructor() { }

  ngOnInit() {
  }

}
