package pl.vm.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.vm.library.entity.UserEntity;

/**
 * The interface User repository.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {

  /**
   * Is user authenticated user to.
   *
   * @param email the email
   * @return the user to
   */
  @Query("Select user from UserEntity user where user.email =:email")
  UserEntity getUserByEmail(@Param("email") String email);
}
