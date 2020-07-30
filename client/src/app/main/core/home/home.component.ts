import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {PopUpService} from '../../shared/pop-up/pop-up.service';
import {LoginComponent} from '../login/login.component';
import {SignInComponent} from '../sign-in/sign-in.component';

@Component({
  selector: 'vm-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(public loginComponent: MatDialog,
              private popUpService: PopUpService) { }

  ngOnInit(): void {
  }

  openLogInDialog(): void {
    const dialogRef = this.loginComponent.open(LoginComponent);

    dialogRef.afterClosed().subscribe(result => {
      this.popUpService.showMessage("Titile", "Message");
    });
  }

  openSignInDialog(): void {
    const dialogRef = this.loginComponent.open(SignInComponent);

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}
