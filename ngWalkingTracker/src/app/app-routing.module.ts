import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContestantListComponent } from './components/contestant-list/contestant-list.component';
import { NotFoundComponent } from './components/not-found/not-found.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'contestants', component: ContestantListComponent },
  { path: '**', component: NotFoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
