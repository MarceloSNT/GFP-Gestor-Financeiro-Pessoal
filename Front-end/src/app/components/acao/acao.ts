import { ChangeDetectorRef, Component, inject, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from "@angular/router";
import { NavBar } from "../nav-bar/nav-bar";
import { AcaoModel } from '../../shared/models/AcaoModel';
import { AçaoService } from '../../services/açao-service';
import { DatePipe, NgClass } from '@angular/common';
import { GestaoModel } from '../../shared/models/GestaoModel';
import { GestaoService } from '../../services/gestao-service';

@Component({
  selector: 'app-acao',
  imports: [NavBar, DatePipe, NgClass],
  templateUrl: './acao.html',
  styleUrl: './acao.scss',
})
export class Acao implements OnInit{
  @Input() acao! : AcaoModel;

  protected gestao : GestaoModel[] = [];

  protected acoes : AcaoModel[] = [];
  protected acaoService = inject(AçaoService);
  protected gestaoService = inject(GestaoService);
  protected route = inject(ActivatedRoute);
  protected router = inject(Router);
  protected cdr = inject(ChangeDetectorRef);
  protected cdGestao!: number;
  protected nuSaldo: number = 0;

ngOnInit() {
  this.route.queryParams.subscribe(params => {
    this.cdGestao = Number(params['cdGestao']);
    if (this.cdGestao) {
      this.carregarAcoes(this.cdGestao);
    }
  });
}

carregarAcoes(cdGestao: number) {
  this.acaoService.getAcoesByCdGestao(cdGestao).subscribe(acoes => {
    this.acoes = acoes;
    this.cdr.detectChanges();
  });
}

criarAcaoNavegar() {
  this.router.navigate(['/criar/acao'], {
    queryParams: { cdGestao: this.cdGestao }
  });
}

deletarAcao(cdAcao: number) {
  this.acaoService.deleteAcao(cdAcao).subscribe(() => {
    this.carregarAcoes(this.cdGestao);
    this.cdr.detectChanges();
  });
}
}
