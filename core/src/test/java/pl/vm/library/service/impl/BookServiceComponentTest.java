package pl.vm.library.service.impl;

import common.AbstractComponentTest;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.vm.library.LibraryApplication;
import pl.vm.library.entity.BookEntity;
import pl.vm.library.entity.ReservationEntity;
import pl.vm.library.entity.UserEntity;
import pl.vm.library.exception.ReservedBookCanNotBeDeletedException;
import pl.vm.library.repository.BookRepository;
import pl.vm.library.repository.ReservationRepository;
import pl.vm.library.repository.UserRepository;
import pl.vm.library.service.BookService;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Component test for BookService
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class)
public class BookServiceComponentTest extends AbstractComponentTest {

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  BookServiceImpl bookService = new BookServiceImpl(bookRepository);

  private Long validBookId = 100L;
  private BookEntity bookEntity = BookTestData.prepareBookEntity();
  private UserEntity userEntity = prepareUserEntity();
  private Instant reservationDate = Instant.parse("2011-07-13T09:12:10.58Z");

  @Test(expected = ReservedBookCanNotBeDeletedException.class)
  public void delete_shouldNotDeleteReservedBook() {
    //Given
    BookEntity savedBook = bookRepository.save(bookEntity);
    UserEntity savedUser = userRepository.save(userEntity);
    ReservationEntity reservationEntity = prepareReservationEntity(savedBook, savedUser);
    reservationRepository.save(reservationEntity);
    //When
    bookService.delete(savedBook.getId());
    //Then
    //exception thrown
  }

  private ReservationEntity prepareReservationEntity(BookEntity bookEntity, UserEntity savedUser) {
    ReservationEntity reservationEntity = new ReservationEntity();
    reservationEntity.setToDate(Instant.now());
    reservationEntity.setFromDate(Instant.now());
    reservationEntity.setBook(bookEntity);
    reservationEntity.setUser(savedUser);
    savedUser.setReservations(Collections.singletonList(reservationEntity));
    return reservationEntity;
  }

  private UserEntity prepareUserEntity() {
    UserEntity userEntity = new UserEntity();
    userEntity.setEmail("email@email.com");
    userEntity.setLastName("lastName");
    userEntity.setName("lastName");
    userEntity.setPassword("password");
    return userEntity;
  }
}