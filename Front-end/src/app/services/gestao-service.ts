import { inject, Injectable } from '@angular/core';
import { GestaoModel } from '../shared/models/GestaoModel';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class GestaoService {
  
  protected http = inject(HttpClient);
  protected gestao! : GestaoModel;
  protected urlApi: string = 'http://localhost:8080/api/gestao';
  protected gestoes!: GestaoModel[];

  public getGestao(cdUsuario : number): Observable<GestaoModel[]> {
    return this.http.get<GestaoModel[]>(`${this.urlApi}/listar/usuario`,
    {
      params: { cdUsuario: cdUsuario }
    });
  }

  public postGestao(payload: GestaoModel): Observable<GestaoModel> {
    return this.http.post<GestaoModel>(`${this.urlApi}/cadastro`, payload);
  }

  public deletarGestao(cdGestao: number): Observable<void> {
    const token = localStorage.getItem('token');
    
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });
    
    return this.http.put<void>(
      `${this.urlApi}/desativar/ativar`,
      {},
      {
        headers,
        params: {cdGestao: cdGestao}
      }
    );
  }
}
