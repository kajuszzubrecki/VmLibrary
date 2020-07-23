import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MainModule} from './main/main/main.module';
import { ResevationComponent } from './main/main/resevation/resevation.component';
import { UserComponent } from './main/main/user/user.component';

@NgModule({
  declarations: [
    AppComponent,
    ,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MainModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
