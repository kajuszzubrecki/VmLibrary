import {Component} from '@angular/core';
import {FormControl, Validators} from '@angular/forms';
import {MatDialogRef} from '@angular/material/dialog';
import {switchMap, take} from 'rxjs/operators';
import {PopUpService} from '../../shared/pop-up/pop-up.service';
import {UserTo} from '../../shared/to/UserTo';
import {UserService} from '../../user/service/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent {

  /**
   * Flag to hide password
   */
  hide = true;

  signInWindowClosed = false;

  /**
   * Email form control
   */
  email = new FormControl('', [Validators.required, Validators.email]);

  private emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

  constructor(private userService: UserService,
              private popUpService: PopUpService,
              private dialogRef: MatDialogRef<SignInComponent>) {
  }

  createAccount(login: any) {
    const userEto = this.prepareUser(login.value.firstName, login.value.lastName, login.value.email, login.value.password);

    const isEmailInvalid = this.emailRegex.test(String(login.value.email).toLowerCase());

    this.userService.isUserEmailAlreadyUsed(login.value.email).pipe(take(1)).subscribe(isUserEmailAlreadyUsed => {
      if (!isUserEmailAlreadyUsed) {
        this.userService.createUser(userEto).subscribe(() => {
          this.dialogRef.close();
        });
      } else {
        this.popUpService.showMessage('Email', 'Account with this email already created');
      }
    });

  }

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }
  }

  private prepareUser(firstName: string, lastName: string, email: string, password: string): UserTo {
    const userEto = new UserTo();
    userEto.name = firstName;
    userEto.lastName = lastName;
    userEto.email = email;
    userEto.password = password;
    return userEto;
  }
}
