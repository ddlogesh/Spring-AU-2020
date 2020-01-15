import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogeshComponent } from './logesh.component';

describe('LogeshComponent', () => {
  let component: LogeshComponent;
  let fixture: ComponentFixture<LogeshComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogeshComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogeshComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
