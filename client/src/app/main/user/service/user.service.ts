import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../../../environments/environment';
import {UserTo} from '../../shared/to/UserTo';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  /**
   * Method creates new user
   *
   * @param userTo
   */
  public createUser(userTo: UserTo): Observable<UserTo> {
    return this.http.post<UserTo>(`${environment.apiUrl}/users/create`, userTo);
  }

  /**
   * Method checks if email provided by user is available to create new account
   * @param email
   */
  public isUserEmailAlreadyUsed(email: string): Observable<boolean> {
    return this.http.get<boolean>(`${environment.apiUrl}/users/validateUserEmail/` + email);
  }
}
