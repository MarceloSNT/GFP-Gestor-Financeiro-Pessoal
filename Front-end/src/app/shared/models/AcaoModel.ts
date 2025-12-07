import { GestaoModel } from "./GestaoModel";
import { StatusModel } from "./StatusModel";
import { TipoModel } from "./TipoModel";

export class AcaoModel{
    constructor(init?: Partial<AcaoModel>) {
    Object.assign(this, init);
  }

    public cdAcao! : number;
    public dsTitulo! : string;
    public dsDescricao! : string;
    public vlValor! : number;
    public dtData! : Date;
    public cdStatus! : number;
    public cdTipo! : number;
    public cdGestao! : number;
}