package pl.vm.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.vm.library.entity.UserEntity;
import pl.vm.library.to.UserTo;

/**
 * The interface User repository.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

  /**
   * Is user email already used user entity.
   *
   * @param email the email
   * @return the user entity
   */
  @Query("Select user from UserEntity user where user.email =:email")
  UserEntity isUserEmailAlreadyUsed(@Param("email") String email);

  /**
   * Is user authenticated user to.
   *
   * @param email    the email
   * @param password the password
   * @return the user to
   */
  @Query("Select user from UserEntity user where user.email =:email and user.password =:password")
  UserEntity isUserAuthenticated(@Param("email") String email, @Param("password") String password);
}
