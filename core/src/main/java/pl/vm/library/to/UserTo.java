package pl.vm.library.to;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.vm.library.facade.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Transport Object for the User class.
 * <p>
 * Contains also the Reservation list of the given User.
 */

@Getter
@Setter
@EqualsAndHashCode
public class UserTo implements Serializable, User {

  private static final long serialVersionUID = 5327766680748073213L;

  private Long id;

  @NotNull
  @Size(max = 255)
  private String name;

  @Size(max = 255)
  private String lastName;

  @NotNull
  @Email
  private String email;

  private String password;

  private List<ReservationTo> reservations = new ArrayList<>();
}
