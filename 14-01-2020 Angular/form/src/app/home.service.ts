import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  data;

  constructor() {
  }


  getData(): { firstName: string; lastName: string; mobile: string; email: string } {
    return this.data;
  }

  setData(value: { firstName: string; lastName: string; mobile: string; email: string }) {
    this.data = value;
  }
}
