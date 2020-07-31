package pl.vm.library.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.vm.library.to.BookTo;

import javax.validation.Valid;
import java.util.List;

/**
 * Interface for BookRestController
 */
@RestController
@RequestMapping("/books/")
@CrossOrigin(origins = "http://localhost:4200")
public interface BookRestController {

  /**
   * Methods finds all books
   *
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "findAll/", produces = MediaType.APPLICATION_JSON_VALUE)
  List<BookTo> findAll();

  /**
   * Methods finds book by ID
   *
   * @param id
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  BookTo findById(@PathVariable Long id);

  /**
   * Method creates new Book
   *
   * @param book
   * @return
   */
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  BookTo create(@Valid @RequestBody BookTo book);

  /**
   * Method delets book by ID
   *
   * @param id
   */
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  void delete(@PathVariable long id);
}
