import { Component, IterableDiffers, OnInit } from '@angular/core';
import { HeaderItem } from '../modals/HeaderItem';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  public headerItems: HeaderItem[] = [
    {
      name:"Home",
      selected:true
    },
    {
      name:"About",
      selected:false
    },
    {
      name:"Properties",
      selected:false
    },
    {
      name:"Blog",
      selected:false
    },
  ];
  constructor() { }

  ngOnInit() {
  }

  changeSelected(selected: HeaderItem){
      this.headerItems.forEach(item=> item.name ===selected.name ? item.selected  = true:  item.selected = false)

  }

}
