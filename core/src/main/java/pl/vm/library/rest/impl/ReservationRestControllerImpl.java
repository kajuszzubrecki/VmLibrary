package pl.vm.library.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.vm.library.service.ReservationService;
import pl.vm.library.to.ReservationExtensionTo;
import pl.vm.library.to.ReservationTo;

import javax.validation.Valid;

/**
 * Implementation of ReservationRestController
 */
@RestController
//@RequestMapping("/books/")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationRestControllerImpl {

  private ReservationService reservationService;

  @Autowired
  public ReservationRestControllerImpl(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  /**
   * Create new reservation
   *
   * @param reservationTo
   * @return
   */
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/reservation/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ReservationTo createNewReservation(@Valid @RequestBody ReservationTo reservationTo) {
    return reservationService.createNewReservation(reservationTo);
  }

  /**
   * Extend reservation with new "To date"
   *
   * @param reservationExtensionTo
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @PostMapping(value = "/reservation/extendReservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ReservationTo extendReservation(@Valid @RequestBody ReservationExtensionTo reservationExtensionTo) {
    return reservationService.extendReservation(reservationExtensionTo);
  }
}
