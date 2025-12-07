import { ChangeDetectorRef, Component, inject, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from "@angular/router";
import { NavBar } from "../nav-bar/nav-bar";
import { AcaoModel } from '../../shared/models/AcaoModel';
import { AçaoService } from '../../services/açao-service';

@Component({
  selector: 'app-acao',
  imports: [RouterLink, NavBar],
  templateUrl: './acao.html',
  styleUrl: './acao.scss',
})
export class Acao implements OnInit{
@Input() acao! : AcaoModel;

  protected acoes : AcaoModel[] = [];
  protected acaoService = inject(AçaoService);
  protected route = inject(ActivatedRoute);
  protected cdr = inject(ChangeDetectorRef);

  ngOnInit() {
  this.route.queryParams.subscribe(params => {
    const cdGestao = params['cdGestao'];
    if (cdGestao) {
      this.carregarAcoes(cdGestao);
    }
  });
}

carregarAcoes(cdGestao: number) {
  this.acaoService.getAcoesByCdGestao(cdGestao).subscribe(acoes => {
    this.acoes = acoes;
    this.cdr.detectChanges();
  });
}
}
