package pl.vm.library.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.vm.library.rest.ReservationRestController;
import pl.vm.library.service.BookService;
import pl.vm.library.service.ReservationService;
import pl.vm.library.to.ReservationTo;

import java.time.Instant;

/**
 * Implementation of ReservationRestController
 */
public class ReservationRestControllerImpl implements ReservationRestController {

  private ReservationService reservationService;

  @Autowired
  public ReservationRestControllerImpl(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  @Override
  public ReservationTo createNewReservation(ReservationTo reservationTo) {
    return reservationService.createNewReservation(reservationTo);
  }

  @Override
  public ReservationTo extendReservation(Long reservationId, Instant newToDate) {
    return reservationService.extendReservation(reservationId, newToDate);
  }
}
