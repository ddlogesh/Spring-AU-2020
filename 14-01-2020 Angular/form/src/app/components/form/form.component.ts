import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {HomeService} from "../../home.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  profileForm;

  constructor(public hs: HomeService, private router: Router, private formBuilder: FormBuilder) {
    this.profileForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      mobile: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]]
    });
  }

  submit(){
    this.hs.setData({
      firstName: this.profileForm.get('firstName').value,
      lastName: this.profileForm.get('lastName').value,
      mobile: this.profileForm.get('mobile').value,
      email: this.profileForm.get('email').value
    });
    this.router.navigate(['/submit']);
  }

  ngOnInit() {

  }
}
