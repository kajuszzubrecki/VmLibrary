package pl.vm.library.to;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Transfer object for user validation
 */
@Data
public class UserAuthTo implements Serializable {

  private static final long serialVersionUID = 5327766680748073213L;

  private String email;

  private String password;
}
