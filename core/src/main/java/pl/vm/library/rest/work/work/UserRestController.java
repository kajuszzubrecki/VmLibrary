package pl.vm.library.rest.work.work;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.vm.library.to.UserAuthTo;
import pl.vm.library.to.UserTo;

import java.util.List;

public interface UserRestController {

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value="/users/",produces = MediaType.APPLICATION_JSON_VALUE)
  List<UserTo> findAll();

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  UserTo findById(@PathVariable Long id);

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value="/users/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  UserTo create(@RequestBody UserTo user);

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value="/users/validateUserEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
  boolean validateMail(@PathVariable String email);

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value="users/authenticate",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  UserTo isUserAuthenticated(@RequestBody UserAuthTo user);
}
