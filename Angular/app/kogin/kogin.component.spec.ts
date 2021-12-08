import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KoginComponent } from './kogin.component';

describe('KoginComponent', () => {
  let component: KoginComponent;
  let fixture: ComponentFixture<KoginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KoginComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
