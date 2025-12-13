export class GestaoModel {
  constructor(init?: Partial<GestaoModel>) {
    Object.assign(this, init);
  }

  cdGestao!: number;
  nmTitulo: string = "";
  nuSaldo : number = 0;
  cdUsuario!: number;
  flAtivo: boolean = true;
}