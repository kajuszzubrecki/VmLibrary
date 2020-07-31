import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SharedModule} from '../shared/shared.module';
import {BookComponent} from './component/book.component';
import {BookService} from './service/book.service';

/**
 * Book module
 */
@NgModule({
  declarations: [BookComponent],
  imports: [
    CommonModule,
    SharedModule
  ],
  exports:[BookComponent],
  providers: [BookService]
})
export class BookModule { }
