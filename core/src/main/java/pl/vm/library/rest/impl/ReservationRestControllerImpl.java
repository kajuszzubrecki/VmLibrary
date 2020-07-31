package pl.vm.library.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.vm.library.service.ReservationService;
import pl.vm.library.to.ReservationTo;

import java.time.Instant;

/**
 * Implementation of ReservationRestController
 */
public class ReservationRestControllerImpl {

  private ReservationService reservationService;

  @Autowired
  public ReservationRestControllerImpl(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  public ReservationTo createNewReservation(ReservationTo reservationTo) {
    return reservationService.createNewReservation(reservationTo);
  }

  public ReservationTo extendReservation(Long reservationId, Instant newToDate) {
    return reservationService.extendReservation(reservationId, newToDate);
  }
}
