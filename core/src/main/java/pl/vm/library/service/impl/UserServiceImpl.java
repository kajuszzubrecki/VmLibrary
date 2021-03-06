package pl.vm.library.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.vm.library.entity.UserEntity;
import pl.vm.library.exception.EntityWithProvidedIdNotFoundException;
import pl.vm.library.exception.ParameterValidationException;
import pl.vm.library.repository.UserRepository;
import pl.vm.library.service.UserService;
import pl.vm.library.to.UserAuthTo;
import pl.vm.library.to.UserTo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  private PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  private ModelMapper mapper = new ModelMapper();

  @Override
  public List<UserTo> findAll() {
    List<UserEntity> allUsers = (List<UserEntity>) userRepository.findAll();

    return allUsers.stream()
        .map(userEntity -> mapper.map(userEntity, UserTo.class))
        .collect(Collectors.toList());
  }

  @Override
  public UserTo findById(Long id) {
    return userRepository.findById(id)
        .map(userEntity -> mapper.map(userEntity, UserTo.class))
        .orElseThrow(EntityWithProvidedIdNotFoundException::new);
  }

  @Override
  public UserTo create(UserTo userTo) {
    validateNewUser(userTo);

    UserEntity userEntity = mapper.map(userTo, UserEntity.class);
    userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    userEntity = userRepository.save(userEntity);

    return mapper.map(userEntity, UserTo.class);
  }

  @Override
  public boolean isUserEmailAlreadyUsed(String email) {
    return userRepository.getUserByEmail(email) != null;
  }

  @Override
  public UserTo isUserAuthenticated(UserAuthTo user) {
    UserEntity userEntity = userRepository.getUserByEmail(user.getEmail());

    if (userEntity != null) {
      String encodedPassword = userEntity.getPassword();
      return passwordEncoder.matches(user.getPassword(), encodedPassword) ? prepareUserToReturn(userEntity) : null;
    } else {
      return null;
    }
  }

  private UserTo prepareUserToReturn(UserEntity userEntity) {
    UserTo userTo = mapper.map(userEntity, UserTo.class);
    userTo.setPassword(null);
    return userTo;
  }

  private void validateNewUser(UserTo userTo) {
    if (CollectionUtils.isNotEmpty(userTo.getReservations())) {
      throw new ParameterValidationException("When creating new User the Reservation list should be initially empty.");
    }
  }
}
