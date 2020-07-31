package pl.vm.library.to;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Transport Object of the Reservation class.
 */
@Getter
@Setter
@EqualsAndHashCode
public class ReservationTo implements Serializable {

  private static final long serialVersionUID = -60690548233543094L;

  private Long id;

  private Long userId;

  private Long bookId;
}