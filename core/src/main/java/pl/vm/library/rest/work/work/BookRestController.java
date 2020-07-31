package pl.vm.library.rest.work.work;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.vm.library.to.BookTo;

import javax.validation.Valid;
import java.util.List;

public interface BookRestController {

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<BookTo> findAll();

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  BookTo findById(@PathVariable Long id);

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  BookTo create(@Valid @RequestBody BookTo book);

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  void delete(@PathVariable long id);
}
