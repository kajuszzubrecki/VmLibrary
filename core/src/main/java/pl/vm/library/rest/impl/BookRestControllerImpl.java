package pl.vm.library.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
import pl.vm.library.rest.work.work.BookRestController;
import pl.vm.library.service.BookService;
import pl.vm.library.to.BookTo;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Book rest controller.
 */
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200")
public class BookRestControllerImpl implements BookRestController {

  @Autowired
  private BookService bookService;

  /**
   * Find all books.
   *
   * @return the list
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public List<BookTo> findAll() {
    return bookService.findAll();
  }

  /**
   * Find by id book to.
   *
   * @param id the id
   * @return the book to
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public BookTo findById(@PathVariable Long id) {
    return bookService.findById(id);
  }

  /**
   * Create new book
   *
   * @param book the book
   * @return the book to
   */
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Override
  public BookTo create(@Valid @RequestBody BookTo book) {
    return bookService.create(book);
  }

  /**
   * Delete book with given ID
   *
   * @param id the id
   */
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  @Override
  public void delete(@PathVariable long id) {
    bookService.delete(id);
  }

}
