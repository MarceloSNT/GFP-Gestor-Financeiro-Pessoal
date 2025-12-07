import { Routes } from '@angular/router';
import { Gestoes } from './components/gestoes/gestoes';
import { CriarGestao } from './components/criar-gestao/criar-gestao';
import { CriarAcao } from './components/criar-acao/criar-acao';
import { Acao } from './components/acao/acao';

export const routes: Routes = [
    {path: "", component: Gestoes},
    {path: "criar/gestao", component: CriarGestao},
    {path: "criar/acao", component: CriarAcao},
    {path: "acao/gestao", component: Acao},
];
