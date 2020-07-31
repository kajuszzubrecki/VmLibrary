package pl.vm.library.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.vm.library.to.ReservationTo;

import java.time.Instant;

/**
 * Interface for ReservationRestControllerImpl
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public interface ReservationRestController {

  ReservationTo createNewReservation(ReservationTo reservationTo);

  ReservationTo extendReservation(Long reservationId, Instant newToDate);
}
