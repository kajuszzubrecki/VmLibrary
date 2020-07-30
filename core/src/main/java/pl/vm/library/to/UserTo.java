package pl.vm.library.to;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.vm.library.facade.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class UserTo implements Serializable, User {

  private static final long serialVersionUID = 5327766680748073213L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(max = 255)
  private String name;

  @Size(max = 255)
	@NotNull
  private String lastName;

  @NotNull
  @Email
  @Size(min = 5, max = 255)
  private String email;

  @NotNull
  @Size(min = 8, max = 255)
  private String password;

  @OneToMany
  private List<ReservationTo> reservations = new ArrayList<>();
}
