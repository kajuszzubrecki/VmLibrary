import {Component, Input, OnInit} from '@angular/core';
import {BookTo} from '../../shared/to/BookTo';

/**
 * Book component to preset single book
 */
@Component({
  selector: 'vw-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.scss']
})
export class BookComponent {

  /**
   * Book to display
   */
  @Input()
  book: BookTo;

  constructor() { }
}
