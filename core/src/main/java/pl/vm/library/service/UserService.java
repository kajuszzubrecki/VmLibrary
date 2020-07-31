package pl.vm.library.service;

import pl.vm.library.to.UserAuthTo;
import pl.vm.library.to.UserTo;

import java.util.List;

/**
 * The Service which contains business logic for User.
 */
public interface UserService {

  /**
   * Returns all Users.
   *
   * @return all Users
   */
  List<UserTo> findAll();

  /**
   * Returns the User with the given ID.
   *
   * @param id the id
   * @return the found User
   */
  UserTo findById(Long id);

  /**
   * Creates a new Entity for the given object.
   *
   * @param userTo the user to
   * @return the persisted User
   */
  UserTo create(UserTo userTo);

  /**
   * Is user email already used boolean.
   *
   * @param email the email
   * @return the boolean
   */
  boolean isUserEmailAlreadyUsed(String email);

  /**
   * Is user authenticated user to.
   *
   * @param user the user
   * @return the user to
   */
  UserTo isUserAuthenticated(UserAuthTo user);
}