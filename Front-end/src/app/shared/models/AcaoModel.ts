import { GestaoModel } from "./GestaoModel";
import { StatusModel } from "./StatusModel";
import { TipoModel } from "./TipoModel";

export class AcaoModel{
    constructor(
        public cdAcao : number,
        public dsTitulo : string,
        public dsDescricao : string,
        public vlValor : number,
        public dtData : Date,
        public status : StatusModel,
        public tipo : TipoModel,
        public gestao : GestaoModel
    ){}
}