package pl.vm.library.rest.impl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import pl.vm.library.to.ReservationTo;

import java.time.Instant;

/**
 * The type Abstract rest controller.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public abstract class AbstractRestController {
  /**
   * Create new reservation reservation to.
   *
   * @param reservationTo the reservation to
   * @return the reservation to
   */
  public abstract ReservationTo createNewReservation(ReservationTo reservationTo);

  /**
   * Extend reservation reservation to.
   *
   * @param reservationId the reservation id
   * @param newToDate     the new to date
   * @return the reservation to
   */
  public abstract ReservationTo extendReservation(Long reservationId, Instant newToDate);
}
