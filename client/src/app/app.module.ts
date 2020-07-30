import {CommonModule} from '@angular/common';
import {MatMenuModule} from '@angular/material/menu';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AppRoutingModule} from './app-routing.module';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {BookModule} from './main/book/book.module';
import {CoreModule} from './main/core/core.module';
import {HomeComponent} from './main/core/home/home.component';
import {ReservationModule} from './main/resevation/reservation.module';
import {UserModule} from './main/user/user.module';


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    CommonModule,
    BookModule,
    ReservationModule,
    UserModule,
    CoreModule,

  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [],
  exports: [

  ]
})
export class AppModule { }
