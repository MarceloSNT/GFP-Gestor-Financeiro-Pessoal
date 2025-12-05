import { Component, Input } from '@angular/core';
import { NavBar } from "../../components/nav-bar/nav-bar";
import { Gestoes } from '../../components/gestoes/gestoes';
import { GestaoModel } from '../../shared/models/GestaoModel';

@Component({
  selector: 'app-home',
  imports: [NavBar, Gestoes],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class Home {
@Input() gestao! : GestaoModel;
}
