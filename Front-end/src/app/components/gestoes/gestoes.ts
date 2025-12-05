import { ChangeDetectorRef, Component, inject, Input, OnInit } from '@angular/core';
import { RouterLink } from "@angular/router";
import { GestaoModel } from '../../shared/models/GestaoModel';
import { GestaoService } from '../../services/gestao-service';
import { NavBar } from "../nav-bar/nav-bar";

@Component({
  selector: 'app-gestoes',
  imports: [RouterLink, NavBar],
  templateUrl: './gestoes.html',
  styleUrl: './gestoes.scss',
})
export class Gestoes implements OnInit{

  @Input() gestao! : GestaoModel;

  protected gestoes : GestaoModel[] = [];
  protected gestoesService = inject(GestaoService);
  protected cdr = inject(ChangeDetectorRef);

ngOnInit(): void {
  this.gestoesService.getGestao().subscribe({
    next: (gestoes) => {
      this.gestoes = gestoes;
    },
    error: (err) => {
      console.error('Erro ao carregar gestões:', err);
    }
  })
  this.cdr.detectChanges();
}
}
