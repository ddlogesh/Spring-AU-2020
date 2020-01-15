import { Component, OnInit } from '@angular/core';
import {HomeServiceService} from "../../home-service.service";

@Component({
  selector: 'app-visak',
  templateUrl: './visak.component.html',
  styleUrls: ['./visak.component.scss'],
  providers: [HomeServiceService]
})
export class VisakComponent implements OnInit {

  constructor(public hs: HomeServiceService) {

  }

  ngOnInit() {
    console.log(this.hs.getTitle());
  }
}
