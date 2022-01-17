import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifiermComponent } from './modifierm.component';

describe('ModifiermComponent', () => {
  let component: ModifiermComponent;
  let fixture: ComponentFixture<ModifiermComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifiermComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifiermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
