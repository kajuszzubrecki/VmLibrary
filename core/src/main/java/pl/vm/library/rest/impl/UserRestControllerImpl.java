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
import pl.vm.library.rest.work.work.UserRestController;
import pl.vm.library.service.UserService;
import pl.vm.library.to.UserAuthTo;
import pl.vm.library.to.UserTo;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestControllerImpl implements UserRestController {

  @Autowired
  private UserService userService;


  @Override
  public List<UserTo> findAll() {
    return userService.findAll();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public UserTo findById(@PathVariable Long id) {
    return userService.findById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/users/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public UserTo create(@RequestBody UserTo user) {
    return userService.create(user);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/users/validateUserEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public boolean validateMail(@PathVariable String email) {
    return userService.isUserEmailAlreadyUsed(email);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "users/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public UserTo isUserAuthenticated(@RequestBody UserAuthTo user) {
    return userService.isUserAuthenticated(user);
  }
}
