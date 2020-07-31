import {Component, OnInit} from '@angular/core';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import {Observable} from 'rxjs';
import {BookService} from '../book/service/book.service';
import {AuthenticationService} from '../core/auth/authentication.service';
import {PopUpService} from '../shared/pop-up/pop-up.service';
import {BookTo} from '../shared/to/BookTo';
import {LoginComponent} from './login/login.component';
import {SignInComponent} from './sign-in/sign-in.component';

@Component({
  selector: 'vm-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  /**
   * Flag if user is logged in
   */
  isUserLogged: boolean;

  /**
   * All available book in library
   */
  books$: Observable<BookTo[]>;

  constructor(public loginComponent: MatDialog,
              private popUpService: PopUpService,
              private authService: AuthenticationService,
              private booksService: BookService) {
  }

  /**
   * Instantiates HomeComponent state
   */
  ngOnInit(): void {
    this.books$ = this.booksService.findAllBooks();
  }

  /**
   * Open LogIn dialog
   */
  openLogInDialog(): void {
    const dialogRef = this.loginComponent.open(LoginComponent);
    this.handleDialogClosing(dialogRef);
  }

  /**
   * Open SignIn dialog
   */
  openSignInDialog(): void {
    const dialogRef = this.loginComponent.open(SignInComponent);
    this.handleDialogClosing(dialogRef);
  }

  /**
   * Logs out user
   */
  logOut() {
    this.authService.logout();
    this.isUserLogged = false;
  }

  private handleDialogClosing<T>(dialogRef: MatDialogRef<T, any>) {
    dialogRef.afterClosed().subscribe(authenticated => {
      if (authenticated) {
        this.isUserLogged = true;
      }
    });
  }
}
