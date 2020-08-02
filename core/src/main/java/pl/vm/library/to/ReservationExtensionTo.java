package pl.vm.library.to;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * Transfer object for reservation extension
 */
@Getter
@Setter
@EqualsAndHashCode
public class ReservationExtensionTo {

  private static final long serialVersionUID = 5327763680748073213L;

  private Long reservationId;
  private Instant newToDate;
}
