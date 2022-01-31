import { Component, Input, OnInit } from '@angular/core';


@Component({
  selector: 'app-shopping-summary',
  templateUrl: './shopping-summary.component.html',
  styleUrls: ['./shopping-summary.component.scss']
})
export class ShoppingSummaryComponent implements OnInit {

  @Input() shoppingSummary: any;

  constructor() { }

  ngOnInit(): void {}


}
