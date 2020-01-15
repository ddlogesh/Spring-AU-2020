import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VisakComponent } from './visak.component';

describe('VisakComponent', () => {
  let component: VisakComponent;
  let fixture: ComponentFixture<VisakComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VisakComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VisakComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
