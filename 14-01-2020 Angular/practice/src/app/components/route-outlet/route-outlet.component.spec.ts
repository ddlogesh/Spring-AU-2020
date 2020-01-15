import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RouteOutletComponent } from './route-outlet.component';

describe('RouteOutletComponent', () => {
  let component: RouteOutletComponent;
  let fixture: ComponentFixture<RouteOutletComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RouteOutletComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RouteOutletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
