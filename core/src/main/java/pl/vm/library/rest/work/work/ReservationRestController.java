package pl.vm.library.rest.work.work;

import pl.vm.library.to.ReservationTo;

import java.time.Instant;

public interface ReservationRestController {
  ReservationTo createNewReservation(ReservationTo reservationTo);

  ReservationTo extendReservation(Long reservationId, Instant newToDate);
}
