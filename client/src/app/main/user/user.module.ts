import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserComponent} from './component/user.component';
import {UserService} from './service/user.service';

@NgModule({
  declarations: [UserComponent],
  imports: [
    CommonModule
  ],
  providers: [UserService]
})
export class UserModule { }
