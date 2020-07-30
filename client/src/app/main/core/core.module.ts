import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {SharedModule} from '../shared/shared.module';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import { SignInComponent } from './sign-in/sign-in.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule
  ],
  declarations: [HomeComponent, LoginComponent, SignInComponent],
  exports: [HomeComponent],
  entryComponents: [SignInComponent, LoginComponent]
})
export class CoreModule {
}
