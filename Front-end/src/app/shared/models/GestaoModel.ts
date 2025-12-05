import { UsuarioModel } from "./UsuarioModel";

export class GestaoModel{
    constructor(
        public cdGestao : number,
        public nmTitulo : string,
        public usuario : UsuarioModel,
        public flAtivo : boolean
    ){}
}