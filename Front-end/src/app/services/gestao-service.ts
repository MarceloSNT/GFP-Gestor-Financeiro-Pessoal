import { inject, Injectable } from '@angular/core';
import { GestaoModel } from '../shared/models/GestaoModel';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class GestaoService {
  
  protected http = inject(HttpClient);
  protected gestao! : GestaoModel;
  protected urlApi: string = 'http://localhost:8080/api/gestao';
  protected gestoes!: GestaoModel[];

  public getGestao(): Observable<GestaoModel[]> {
    return this.http.get<GestaoModel[]>(`${this.urlApi}/listar`);
  }

  public postGestao(payload: GestaoModel): Observable<GestaoModel> {
    return this.http.post<GestaoModel>(`${this.urlApi}/cadastro`, payload);
  }
}
