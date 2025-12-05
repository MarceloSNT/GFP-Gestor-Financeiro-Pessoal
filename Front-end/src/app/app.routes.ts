import { Routes } from '@angular/router';
import { Home } from './views/home/home';
import { Gestoes } from './components/gestoes/gestoes';

export const routes: Routes = [
    {path: "", component: Home},
    {path: "gestoes", component: Gestoes}
];
