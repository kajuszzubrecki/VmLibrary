import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'vm-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  /**
   * Flag to hide password
   */
  hide = true;
  password: string;
  name: string;

  constructor() { }

  login(login: any) {
    console.log(login.value.username, login.value.password);
  }
}
