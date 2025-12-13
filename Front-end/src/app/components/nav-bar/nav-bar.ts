import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from "@angular/router";

@Component({
  selector: 'app-nav-bar',
  imports: [RouterLink],
  templateUrl: './nav-bar.html',
  styleUrl: './nav-bar.scss',
})
export class NavBar {
  public route = inject(Router);

  public logout(){
    localStorage.clear();
    this.route.navigate(['/login']);
  }
}
