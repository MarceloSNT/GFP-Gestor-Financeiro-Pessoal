import { ChangeDetectorRef, Component, inject, Input, OnInit } from '@angular/core';
import { Router, RouterLink } from "@angular/router";
import { GestaoModel } from '../../shared/models/GestaoModel';
import { GestaoService } from '../../services/gestao-service';
import { NavBar } from "../nav-bar/nav-bar";
import { UsuarioModel } from '../../shared/models/UsuarioModel';
import { AçaoService } from '../../services/açao-service';
import { AcaoModel } from '../../shared/models/AcaoModel';


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
  protected router = inject(Router);

ngOnInit(): void {
  this.gestoesService.getGestao().subscribe({
    next: (gestoes) => {
      this.gestoes = gestoes;
  this.cdr.detectChanges();
    },
    error: (err) => {
      console.error('Erro ao carregar gestões:', err);
  this.cdr.detectChanges();
    }
  })
  this.cdr.detectChanges();
}


  
abrirAcoes(cdGestao: number) {
  this.router.navigate(['/acao/gestao'], {
    queryParams: { cdGestao }
  });
}

}
