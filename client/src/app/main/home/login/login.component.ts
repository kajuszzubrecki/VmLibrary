import {Component} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {first} from 'rxjs/operators';
import {AuthenticationService} from '../../core/auth/authentication.service';
import {PopUpService} from '../../shared/pop-up/pop-up.service';

@Component({
  selector: 'vm-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  /**
   * Flag to hide password
   */
  isPasswordNotVisible = true;

  constructor(private authService: AuthenticationService,
              private popUpService: PopUpService,
              private dialogRef: MatDialogRef<LoginComponent>) {
  }

  /**
   * Log in user
   *
   * @param data
   */
  login(data: any) {
    this.authService.login(data.value.email, data.value.password).pipe(first()).subscribe(user => {
      if (user != null) {
        this.dialogRef.close(true);
      } else {
        this.popUpService.showMessage('Login', 'Invalid email or password. Please try again :)')
      }
    });
  }
}
