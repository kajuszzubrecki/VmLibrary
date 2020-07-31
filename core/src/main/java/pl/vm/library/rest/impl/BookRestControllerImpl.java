package pl.vm.library.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.vm.library.rest.BookRestController;
import pl.vm.library.service.BookService;
import pl.vm.library.to.BookTo;

import java.util.List;

/**
 * Rest controller for Books
 */
public class BookRestControllerImpl implements BookRestController {

  private BookService bookService;

  @Autowired
  public BookRestControllerImpl(BookService bookService) {
    this.bookService = bookService;
  }

  @Override
  public List<BookTo> findAll() {
    return bookService.findAll();
  }

  @Override
  public BookTo findById(Long id) {
    return bookService.findById(id);
  }

  @Override
  public BookTo create(BookTo book) {
    return bookService.create(book);
  }

  @Override
  public void delete(long id) {
    bookService.delete(id);
  }
}
