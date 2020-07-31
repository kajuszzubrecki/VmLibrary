package pl.vm.library.to;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Transfer object for user validation
 */
@Getter
@Setter
@EqualsAndHashCode
public class UserAuthTo implements Serializable {

  private static final long serialVersionUID = 5327766680748073213L;

  private String email;

  private String password;
}
