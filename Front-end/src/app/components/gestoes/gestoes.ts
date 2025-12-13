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

  protected cdUsuario: number = Number(localStorage.getItem('cdUsuario'));
  protected nmUsuario: string = String(localStorage.getItem('nmUsuario'));

ngOnInit(): void {
  this.gestoesService.getGestao(this.cdUsuario).subscribe({
    next: (gestoes) => {
      console.log('Sucesso ao carregar gestões:', gestoes);
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

deletarGestao(cdGestao: number) {
  this.gestoesService.deletarGestao(cdGestao).subscribe(() => {
    this.gestoes = this.gestoes.filter(gestao => gestao.cdGestao !== cdGestao);
    this.cdr.detectChanges();
  });
}
}
