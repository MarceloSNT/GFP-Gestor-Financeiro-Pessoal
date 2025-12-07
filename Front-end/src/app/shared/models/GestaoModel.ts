export class GestaoModel {
  constructor(init?: Partial<GestaoModel>) {
    Object.assign(this, init);
  }

  cdGestao!: number;
  nmTitulo: string = "";
  cdUsuario!: number;
  flAtivo: boolean = true;
}