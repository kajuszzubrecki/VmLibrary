package pl.vm.library.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.vm.library.service.BookService;
import pl.vm.library.to.BookTo;

import javax.validation.Valid;
import java.util.List;

/**
 * Interface for BookRestController
 */
@RestController
//@RequestMapping("/books/")
@CrossOrigin(origins = "http://localhost:4200")
public class BookRestControllerImpl {

  private BookService bookService;

  @Autowired
  public BookRestControllerImpl(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * Methods finds all books
   *
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/books/findAll/", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<BookTo> findAll() {
    return bookService.findAll();
  }

  /**
   * Methods finds book by ID
   *
   * @param id
   * @return
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public BookTo findById(@PathVariable Long id) {
    return bookService.findById(id);
  }

  /**
   * Method creates new Book
   *
   * @param book
   * @return
   */
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/books/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  BookTo create(@Valid @RequestBody BookTo book) {
    return bookService.create(book);
  }

  /**
   * Method delets book by ID
   *
   * @param id
   */
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/books/{id}")
  public void delete(@PathVariable long id) {
    bookService.delete(id);
  }
}
