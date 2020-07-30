import {CommonModule} from '@angular/common';
import {MatMenuModule} from '@angular/material/menu';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AppRoutingModule} from './app-routing.module';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {BookModule} from './main/book/book.module';
import {HomeModule} from './main/home/home.module';
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
    HomeModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [],
  exports: [

  ]
})
export class AppModule { }
