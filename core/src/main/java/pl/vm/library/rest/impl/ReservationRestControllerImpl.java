package pl.vm.library.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.vm.library.rest.work.work.ReservationRestController;
import pl.vm.library.service.ReservationService;
import pl.vm.library.to.ReservationTo;

import java.time.Instant;

@RequestMapping("/reservations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationRestControllerImpl implements ReservationRestController {

  @Autowired
  private ReservationService reservationService;

  @Override
  public ReservationTo createNewReservation(ReservationTo reservationTo) {
    return reservationService.createNewReservation(reservationTo);
  }

  @Override
  public ReservationTo extendReservation(Long reservationId, Instant newToDate) {
    return reservationService.extendReservation(reservationId, newToDate);
  }
}
