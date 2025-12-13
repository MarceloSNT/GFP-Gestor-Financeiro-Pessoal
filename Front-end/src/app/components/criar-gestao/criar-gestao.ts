import { ChangeDetectorRef, Component, inject, Inject } from '@angular/core';
import { NavBar } from "../nav-bar/nav-bar";
import { FormsModule } from '@angular/forms';
import { GestaoModel } from '../../shared/models/GestaoModel';
import { GestaoService } from '../../services/gestao-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-criar-gestao',
  standalone: true,
  imports: [NavBar, FormsModule],
  templateUrl: './criar-gestao.html',
  styleUrl: './criar-gestao.scss',
})
export class CriarGestao {

  protected gestoesService = inject(GestaoService);
  protected cdr = inject(ChangeDetectorRef);
  protected route = inject(Router)
  protected cdUsuario: number = Number(localStorage.getItem('cdUsuario'));

  protected payload: GestaoModel = new GestaoModel({
  nmTitulo: "",
  cdUsuario: this.cdUsuario,
  flAtivo: true
  });

criarGestao() {
  console.log("Payload enviado:", this.payload);
  this.gestoesService.postGestao(this.payload)
    .subscribe({
      next: (response) => {console.log("Criado:", response)
      this.route.navigate([''])
      },
      error: (err) => console.error("Erro:", err)
    });
}
}
