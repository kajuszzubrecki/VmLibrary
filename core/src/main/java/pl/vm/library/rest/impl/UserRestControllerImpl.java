package pl.vm.library.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.vm.library.rest.UserRestController;
import pl.vm.library.service.UserService;
import pl.vm.library.to.UserAuthTo;
import pl.vm.library.to.UserTo;

import java.util.List;

/**
 * Implementation for UserRestController
 */
public class UserRestControllerImpl implements UserRestController {

  @Autowired
  private UserService userService;

  /**
   * Finds all users
   *
   * @return
   */
  @Override
  public List<UserTo> findAll() {
    return userService.findAll();
  }

  /**
   * Method finds user by ID
   *
   * @param id
   * @return
   */
  @Override
  public UserTo findById(Long id) {
    return userService.findById(id);
  }

  /**
   * Methods validates email
   *
   * @param email
   * @return
   */
  @Override
  public boolean validateMail(String email) {
    return userService.isUserEmailAlreadyUsed(email);
  }

  /**
   * Methods creates new user
   *
   * @param user
   * @return
   */
  @Override
  public UserTo create(UserTo user) {
    return userService.create(user);
  }

  /**
   * Methods checks if user is authenticated
   *
   * @param user
   * @return
   */
  @Override
  public UserTo isUserAuthenticated(UserAuthTo user) {
    return userService.isUserAuthenticated(user);
  }
}
