import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthGuard} from './main/core/auth-guard/auth.guard';
import {HomeComponent} from './main/home/home.component';
import {LoginComponent} from './main/home/login/login.component';

const routes: Routes = [
  {
    path: 'home', component: HomeComponent,
    // canActivate: [AuthGuard],
  },
/*  {
    path: 'mybooks', component: MyBooks, //todo implement new component to show AuthGuard in action
    canActivate: [AuthGuard],
  },*/
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: '**', redirectTo: '/home'}
];

/**
 * Main routing module of application- responsible for configuration of basic url to component mappings
 */
@NgModule({
  imports: [RouterModule.forRoot(routes, {})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
