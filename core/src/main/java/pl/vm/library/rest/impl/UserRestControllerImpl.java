package pl.vm.library.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.vm.library.service.UserService;
import pl.vm.library.to.UserAuthTo;
import pl.vm.library.to.UserTo;

import java.util.List;

/**
 * Implementation for UserRestController
 */
@RestController
//@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestControllerImpl {

  private UserService userService;

  @Autowired
  public UserRestControllerImpl(UserService userService) {
    this.userService = userService;
  }

  /**
   * Finds all users
   *
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/users/", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserTo> findAll() {
    return userService.findAll();
  }

  /**
   * Method finds user by ID
   *
   * @param id
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserTo findById(@PathVariable Long id) {
    return userService.findById(id);
  }

  /**
   * Methods validates email
   *
   * @param email
   * @return
   */
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public boolean validateMail(@PathVariable String email) {
    return userService.isUserEmailAlreadyUsed(email);
  }

  /**
   * Methods creates new user
   *
   * @param user
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/users/validateUserEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
  public UserTo create(@RequestBody UserTo user) {
    return userService.create(user);
  }

  /**
   * Methods checks if user is authenticated
   *
   * @param user
   * @return
   */
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/users/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public UserTo isUserAuthenticated(@RequestBody UserAuthTo user) {
    return userService.isUserAuthenticated(user);
  }
}
