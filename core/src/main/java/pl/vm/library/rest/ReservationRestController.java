package pl.vm.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.vm.library.service.ReservationService;

@RequestMapping("/reservations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationRestController extends AbstractRestController {

	@Autowired
	private ReservationService reservationService;

	// TODO Create reservation.

	// TODO Extend reservation - change the "toDate" Date in the given reservation

}
