import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule
  ],
  declarations: [HomeComponent, LoginComponent],
  exports: [HomeComponent, LoginComponent]
})
export class CoreModule {
}
