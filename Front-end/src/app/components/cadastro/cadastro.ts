import { Component, inject } from '@angular/core';
import { Router, RouterLink } from "@angular/router";
import { AuthService } from '../../services/auth-service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cadastro',
  standalone: true,
  imports: [RouterLink, FormsModule],
  templateUrl: './cadastro.html',
  styleUrl: './cadastro.scss',
})
export class Cadastro {

  protected nmUsuario: string = '';
  protected dsEmail: string = '';
  protected dsSenha: string = '';
  protected flAtivo: boolean = true;
  protected role : string = 'USER';

  protected router = inject(Router);
  protected authService = inject(AuthService);

  public registro() {
    this.authService.registro(this.nmUsuario, this.dsEmail, this.dsSenha, this.flAtivo, this.role).subscribe({
      next: (response) => {
        console.log('Registro bem-sucedido:', response);
        this.router.navigate(['/login']);
      },
      error: (error) => {
        console.error('Erro no registro:', error);
      }
    });
  }
}
