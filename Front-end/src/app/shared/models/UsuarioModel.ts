import { RoleModel } from "./RoleModel";

export class UsuarioModel{
    constructor(
        public cdUsuario : number,
        public nmUsuario : string,
        public dsEmail : string,
        public dsSenha : string,
        public role : RoleModel
    ){}
}