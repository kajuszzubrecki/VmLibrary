package pl.vm.library.service;

import pl.vm.library.to.BookTo;

import java.util.List;

/**
 * The Service which contains business logic for Book.
 */
public interface BookService {

  /**
   * Returns all Books.
   *
   * @return all Books
   */
  List<BookTo> findAll();

  /**
   * Returns the Book with the given ID.
   *
   * @param id the id
   * @return the found Book
   */
  BookTo findById(Long id);

  /**
   * Creates a new Entity for the given object.
   *
   * @param book the book
   * @return the persisted Book
   */
  BookTo create(BookTo book);

  /**
   * Deletes the Book with the given id.
   *
   * @param id the id
   * @return the persisted Book
   */
  void delete(Long id);
}
