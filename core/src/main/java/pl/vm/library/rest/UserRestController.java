package pl.vm.library.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.vm.library.to.UserAuthTo;
import pl.vm.library.to.UserTo;

import java.util.List;

/**
 * Interface for UserRestControllerImpl
 */
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public interface UserRestController {

  /**
   * Finds all users
   *
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  List<UserTo> findAll();

  /**
   * Finds user by ID
   *
   * @param id
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  UserTo findById(@PathVariable Long id);

  /**
   * Creates user
   *
   * @param user
   * @return
   */
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  UserTo create(@RequestBody UserTo user);

  /**
   * Validate if email is assigned to already created account
   *
   * @param email
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/validateUserEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
  boolean validateMail(@PathVariable String email);

  /**
   * Checks if given user exists
   *
   * @param user
   * @return
   */
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  UserTo isUserAuthenticated(@RequestBody UserAuthTo user);
}
