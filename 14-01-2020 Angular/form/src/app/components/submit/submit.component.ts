import {Component, OnInit} from '@angular/core';
import {HomeService} from "../../home.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-submit',
  templateUrl: './submit.component.html',
  styleUrls: ['./submit.component.scss']
})
export class SubmitComponent implements OnInit {

  data;

  constructor(public hs: HomeService, private router: Router) {
  }

  ngOnInit() {
    if(this.hs.getData())
      this.data = this.hs.getData();
    else {
      alert('No data found!');
      this.router.navigate(['/form']);
    }
  }
}
