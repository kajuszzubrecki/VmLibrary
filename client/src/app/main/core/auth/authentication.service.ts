import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable, of} from 'rxjs';
import {map} from 'rxjs/operators';
import {environment} from '../../../../environments/environment';
import {UserAuthTo} from '../../shared/to/UserAuthTo';
import {UserTo} from '../../shared/to/UserTo';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private currentUserSubject: BehaviorSubject<UserTo>;
  public currentUser: Observable<UserTo>;

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<UserTo>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): UserTo {
    return this.currentUserSubject.value;
  }

  /**
   * Method to log the user
   *
   * @param email
   * @param password
   */
  login(email: string, password?: string): Observable<UserTo> {
    const userAuthTo = new UserAuthTo();
    userAuthTo.email = email;
    userAuthTo.password = password;
    if (password != 'undefined') {
      return this.http.post<any>(`${environment.apiUrl}/users/authenticate`, userAuthTo)
        .pipe(map(user => {
          localStorage.setItem('currentUser', JSON.stringify(user));
          this.currentUserSubject.next(user);
          return user;
        }));
    } else {
      localStorage.setItem('currentUser', JSON.stringify({name: email}));
      this.currentUserSubject.next({name: email} as UserTo);
      return of({name: email} as UserTo);
    }
  }

  /**
   * Method logs out the user
   */
  logout() {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
}
