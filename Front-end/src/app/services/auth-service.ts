import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  protected apiUrl = 'http://localhost:8080/api/auth/';
  private http = inject(HttpClient);

  public login(dsEmail : string , dsSenha : string): Observable<any>{
    return this.http.post(`${this.apiUrl}login`,{dsEmail, dsSenha});
}

  public registro(nmUsuario : string, dsEmail : string , dsSenha : string, flAtivo : boolean, role : string): Observable<any>{
    return this.http.post(`${this.apiUrl}registro`,{nmUsuario, dsEmail, dsSenha, flAtivo, role});
  }

}
