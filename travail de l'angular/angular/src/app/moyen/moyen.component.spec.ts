import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoyenComponent } from './moyen.component';

describe('MoyenComponent', () => {
  let component: MoyenComponent;
  let fixture: ComponentFixture<MoyenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoyenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MoyenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
