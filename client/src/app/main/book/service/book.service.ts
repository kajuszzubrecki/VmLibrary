import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {BookTo} from '../../shared/to/BookTo';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private httpClient: HttpClient) {
  }

  /**
   * Finds all books
   */
  public findAllBooks(): Observable<BookTo[]> {
    return this.httpClient.get<BookTo[]>(`${environment.apiUrl}/books/findAll/`);
  }
}
