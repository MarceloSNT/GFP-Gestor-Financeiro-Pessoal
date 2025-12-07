import { RoleModel } from "./RoleModel";

export class UsuarioModel {
  cdUsuario!: number;
  nmUsuario!: string;
  dsEmail!: string;
  dsSenha!: string;
  role!: RoleModel;

  constructor(init?: Partial<UsuarioModel>) {
    Object.assign(this, init);
  }
}
