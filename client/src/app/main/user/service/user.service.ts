import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {UserTo} from '../../shared/to/UserTo';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  public createUser(userTo: UserTo): Observable<UserTo> {
    return this.http.post<UserTo>('http://localhost:8080/users/create', userTo);
  }

  public isUserEmailAlreadyUsed(email: string): Observable<boolean>  {
    return this.http.get<boolean>('http://localhost:8080/users/validateUserEmail/' + email);
  }
}
