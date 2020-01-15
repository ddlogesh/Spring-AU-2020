import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-session-detail',
  templateUrl: './session-detail.component.html',
  styleUrls: ['./session-detail.component.scss']
})
export class SessionDetailComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input()
  titles = 'session-details-title';
  @Output()
  trainer1 = new EventEmitter<String>();

  func(k){
    this.trainer1.emit("logeshfddssd");
  }

  word = 'Darbar';
  session = {
    name : 'Angular',
    trainer: 'Jegan'
  };

  isDisabled = false;

  toggleInput() {
    this.session.trainer = 'Logeshhhhh';
    this.isDisabled = !this.isDisabled;
  }
}
