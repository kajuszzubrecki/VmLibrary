package pl.vm.library.service.impl;

import common.AbstractModuleTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import pl.vm.library.entity.BookEntity;
import pl.vm.library.repository.BookRepository;
import pl.vm.library.to.BookTo;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit test class with mocks for BookServiceImpl
 */
public class BookServiceModuleTest extends AbstractModuleTest {

  @Mock
  private BookRepository bookRepository;

  @InjectMocks
  BookServiceImpl bookService = new BookServiceImpl(bookRepository);

  private Long validBookId = 1L;
  private ModelMapper mapper = new ModelMapper();

  @Test
  public void findById_shouldFindBookByGivenId() {
    //Given
    BookTo bookTo = BookTestData.prepareBookTo();
    BookEntity bookEntity = mapper.map(bookTo, BookEntity.class);
    prepareMocks(bookEntity);

    //When
    BookTo foundBook = bookService.findById(validBookId);

    //Then
    assertThat(foundBook).isEqualToComparingFieldByField(bookEntity);
  }

  @Test(expected = EntityNotFoundException.class)
  public void findById_shouldThrowExceptionWhenIdIsInvalid() {
    // When
    bookService.findById(999L);

    //Then
    //exception thrown
  }

  private void prepareMocks(BookEntity bookEntity) {
    Mockito.doReturn(Optional.of(bookEntity))
        .when(bookRepository)
        .findById(validBookId);
  }
}
