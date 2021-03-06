package pl.vm.library.to;


import lombok.Data;
import lombok.NoArgsConstructor;
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

@Data
@NoArgsConstructor
public class UserTo implements Serializable, User {

  private static final long serialVersionUID = 5327766680348073213L;

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
