import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {AuthenticationService} from '../core/auth/authentication.service';
import {PopUpService} from '../shared/pop-up/pop-up.service';
import {LoginComponent} from './login/login.component';
import {SignInComponent} from './sign-in/sign-in.component';

@Component({
  selector: 'vm-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  isUserLogged: boolean;

  constructor(public loginComponent: MatDialog,
              private popUpService: PopUpService,
              private authService: AuthenticationService) {
  }

  ngOnInit(): void {
  }

  openLogInDialog(): void {
    const dialogRef = this.loginComponent.open(LoginComponent);
    dialogRef.afterClosed().subscribe(authenticated => {
      if (authenticated) {
        this.isUserLogged = true;
      }
    });

  }

  openSignInDialog(): void {
    const dialogRef = this.loginComponent.open(SignInComponent);

    dialogRef.afterClosed().subscribe(authenticated => {
      if (authenticated) {
        this.isUserLogged = true;
      }
    });
  }

  logOut() {
    this.authService.logout();
  }
}
