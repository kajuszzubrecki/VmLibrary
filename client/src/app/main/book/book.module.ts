import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BookComponent} from './component/book.component';
import {BookService} from './service/book.service';

@NgModule({
  declarations: [BookComponent],
  imports: [
    CommonModule
  ],
  providers: [BookService]
})
export class BookModule { }
