import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {ResevationComponent} from './resevation/resevation.component';
import {UserComponent} from './user/user.component';
import { BookComponent } from './book/book.component';


@NgModule({
  declarations: [
    ResevationComponent,
    UserComponent,
    BookComponent],
  imports: [
    CommonModule
  ]
})
export class MainModule {
}
