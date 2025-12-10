import { ChangeDetectorRef, Component, inject, Input } from '@angular/core';
import { NavBar } from "../nav-bar/nav-bar";
import { ActivatedRoute, Router } from '@angular/router';
import { AçaoService } from '../../services/açao-service';
import { AcaoModel } from '../../shared/models/AcaoModel';
import { FormsModule } from '@angular/forms';
import { GestaoModel } from '../../shared/models/GestaoModel';

@Component({
  selector: 'app-criar-acao',
  standalone: true,
  imports: [NavBar, FormsModule],
  templateUrl: './criar-acao.html',
  styleUrl: './criar-acao.scss',
})
export class CriarAcao {
  
protected router = inject(ActivatedRoute);
  protected acaoService = inject(AçaoService);
  protected cdr = inject(ChangeDetectorRef);
  protected route = inject(Router)

  protected payload: AcaoModel = new AcaoModel({
    dsTitulo : "",
    dsDescricao : "",
    vlValor : 0,
    cdStatus : 0,
    dtData : new Date(),
    cdTipo : 0,
    cdGestao : 0
  });

  criarAcao(){
    this.router.queryParams.subscribe(params => {
        
      console.log("Params recebidos:", params);

    const cdGestao = params['cdGestao'];
    this.payload.cdGestao = Number(cdGestao);
    

    this.acaoService.postAcao(this.payload)
    .subscribe({
      next: (response) => {console.log("Criado:", response)
      this.route.navigate([''])
      console.log("Payload",this.payload)

      },
      error: (err) => {console.error("Erro:", err),
      console.log("Payload",this.payload)
      }
    });
  });
}}
