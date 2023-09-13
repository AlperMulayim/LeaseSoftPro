import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { BuildingFilter } from 'src/app/modals/BuildingFilter';

@Component({
  selector: 'app-building-filter-panel',
  templateUrl: './building-filter-panel.component.html',
  styleUrls: ['./building-filter-panel.component.scss']
})
export class BuildingFilterPanelComponent implements OnInit {

  public filterModel: BuildingFilter = new BuildingFilter();

  @Output()
  public searchFilter: EventEmitter<BuildingFilter> = new EventEmitter<BuildingFilter>()

  constructor() { }

  ngOnInit() {
  }

  public filter(): void{
      console.log("click filter");
      console.log(this.filterModel);
      this.searchFilter.emit(this.filterModel);
  }
}
