import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ResevationComponent} from './component/resevation.component';
import {ReservationService} from './service/reservation.service';



@NgModule({
  declarations: [ResevationComponent],
  imports: [
    CommonModule
  ],
  providers: [ReservationService]
})
export class ReservationModule { }
