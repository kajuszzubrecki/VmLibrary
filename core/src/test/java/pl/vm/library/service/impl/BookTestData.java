package pl.vm.library.service.impl;

import pl.vm.library.entity.BookEntity;
import pl.vm.library.to.BookTo;

import java.time.Instant;

/**
 * Test data for Book
 */
public class BookTestData {

  /**
   * The constant author.
   */
  public static String author = "Author";
  /**
   * The constant isbn.
   */
  public static String isbn = "ISBN_ISBN_ISB";
  /**
   * The constant title.
   */
  public static String title = "Title";
  /**
   * The constant reservationDate.
   */
  public static Instant reservationDate = Instant.parse("2011-07-13T09:12:10.58Z");

  /**
   * Prepare book entity book entity.
   *
   * @return the book entity
   */
  public static BookEntity prepareBookEntity() {
    BookEntity bookEntity = new BookEntity();
    bookEntity.setIsbn(isbn);
    bookEntity.setTitle(title);
    bookEntity.setAuthor(author);
    bookEntity.setReleaseDate(reservationDate);
    return bookEntity;
  }

  /**
   * Prepare book to book to.
   *
   * @return the book to
   */
  public static BookTo prepareBookTo() {
    BookTo bookEntity = new BookTo();
    bookEntity.setIsbn(isbn);
    bookEntity.setTitle(title);
    bookEntity.setAuthor(author);
    bookEntity.setReleaseDate(reservationDate);
    return bookEntity;
  }
}
