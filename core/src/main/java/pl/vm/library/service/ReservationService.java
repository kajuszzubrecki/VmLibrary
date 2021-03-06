package pl.vm.library.service;

import pl.vm.library.to.ReservationExtensionTo;
import pl.vm.library.to.ReservationTo;

import java.time.Instant;

/**
 * The Service which contains business logic for Reservation.
 */
public interface ReservationService {

  /**
   * Create new reservation reservation to.
   *
   * @param reservationTo the reservation to
   * @return the reservation to
   */
  ReservationTo createNewReservation(ReservationTo reservationTo);

  /**
   * Extend reservation reservation to.
   *
   * @param reservationExtensionTo the reservation extension to
   * @return the reservation to
   */
  ReservationTo extendReservation(ReservationExtensionTo reservationExtensionTo);
}
