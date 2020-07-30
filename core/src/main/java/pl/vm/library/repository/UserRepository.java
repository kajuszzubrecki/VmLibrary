package pl.vm.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.vm.library.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

  @Query("Select user from UserEntity user where user.email =:email")
  UserEntity isUserEmailAlreadyUsed(@Param("email") String email);
}
