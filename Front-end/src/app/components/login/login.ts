import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from "@angular/router";
import { AuthService } from '../../services/auth-service';

@Component({
  selector: 'app-login',
  imports: [RouterLink, FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {

  protected dsEmail: string = '';
  protected dsSenha: string = '';

  protected router = inject(Router);
  protected authService = inject(AuthService);

  public login() {
    this.authService.login(this.dsEmail, this.dsSenha).subscribe({
      next: (response) => {
        console.log('Login bem-sucedido:', response);
        localStorage.setItem('token', response.token);
        localStorage.setItem('cdUsuario', response.cdUsuario);
        localStorage.setItem('nmUsuario', response.nmUsuario);
        localStorage.setItem('dsEmail', response.dsEmail);
        localStorage.setItem('role', response.role);
        
        if(response.token == null){
          alert("Login ou senha incorretos!");
        }else{
          this.router.navigate(['']);
        }
      },
      error: (error) => {
        console.error('Erro no login:', error);
      }
    });
  }
}
