import { HttpClient, HttpHeaders } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { GestaoModel } from '../shared/models/GestaoModel';
import { AcaoModel } from '../shared/models/AcaoModel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AçaoService {
  
  protected http = inject(HttpClient);
  protected acao! : AcaoModel;
  protected urlApi: string = 'http://localhost:8080/api/acao';
  
  

  public postAcao(payload: AcaoModel): Observable<AcaoModel> {
    return this.http.post<AcaoModel>(`${this.urlApi}/cadastro`, payload);
  }

  public getAcoesByCdGestao(cdGestao: number): Observable<AcaoModel[]> {
    return this.http.get<AcaoModel[]>(`${this.urlApi}/listar/gestao`, {
    params: { cdGestao: cdGestao }
  });
  }

  public deleteAcao(cdAcao: number): Observable<void> {
  const token = localStorage.getItem('token');
    
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`
    });

    return this.http.put<void>(
    `${this.urlApi}/desativar/ativar`,
    {},
    {
      headers,
      params: { cdAcao: cdAcao }
    }
  );
}

}
