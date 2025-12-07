import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarGestao } from './criar-gestao';

describe('CriarGestao', () => {
  let component: CriarGestao;
  let fixture: ComponentFixture<CriarGestao>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CriarGestao]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CriarGestao);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
