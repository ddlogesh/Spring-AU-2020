import {Component, OnInit} from '@angular/core';
import {HomeServiceService} from "../../home-service.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-logesh',
  templateUrl: './logesh.component.html',
  styleUrls: ['./logesh.component.scss'],
  providers: [HomeServiceService]
})

export class LogeshComponent implements OnInit {

  profileForm;

  constructor() {
    this.profileForm = new FormGroup({
      firstName: new FormControl('Logesh'),
      lastName: new FormControl(''),
      address: new FormGroup({
        num: new FormControl()
      })
    });
  }

  submit(){
    console.log(this.profileForm.get('firstName').value);
  }

  ngOnInit() {
    //console.log(this.hs.getTitle());
    //this.hs.setTitle("kjbgjkjkjgkjkjgkgkj");
  }
}
