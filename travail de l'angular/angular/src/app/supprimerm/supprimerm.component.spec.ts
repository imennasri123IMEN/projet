import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimermComponent } from './supprimerm.component';

describe('SupprimermComponent', () => {
  let component: SupprimermComponent;
  let fixture: ComponentFixture<SupprimermComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SupprimermComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
