import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarAcao } from './criar-acao';

describe('CriarAcao', () => {
  let component: CriarAcao;
  let fixture: ComponentFixture<CriarAcao>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CriarAcao]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CriarAcao);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
