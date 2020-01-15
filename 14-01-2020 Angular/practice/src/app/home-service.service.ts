import { Injectable } from '@angular/core';

@Injectable()
export class HomeServiceService {

  title = "";

  constructor() { }

  mainService(){
    console.log('main-service called');
  }

  setTitle(title){
    this.title = title;
  }

  getTitle(){
    return this.title;
  }
}
