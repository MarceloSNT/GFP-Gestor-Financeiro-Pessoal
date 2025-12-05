import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Gestoes } from './gestoes';

describe('Gestoes', () => {
  let component: Gestoes;
  let fixture: ComponentFixture<Gestoes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Gestoes]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Gestoes);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
