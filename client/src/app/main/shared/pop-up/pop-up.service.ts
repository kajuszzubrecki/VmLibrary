import {Injectable} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {PopUpComponent} from './pop-up.component';

@Injectable({
  providedIn: 'root'
})
export class PopUpService {

  constructor(private matDialog: MatDialog) {
  }

  public showMessage(title: string, message: string) {
    this.matDialog.open(PopUpComponent, {
      data: {
        message: message,
        title: title
      }
    })
  }
}
