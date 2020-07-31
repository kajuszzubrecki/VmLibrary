package pl.vm.library.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.vm.library.entity.BookEntity;
import pl.vm.library.exception.ParameterValidationException;
import pl.vm.library.exception.ReservedBookCanNotBeDeletedException;
import pl.vm.library.repository.BookRepository;
import pl.vm.library.service.BookService;
import pl.vm.library.to.BookTo;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  private ModelMapper mapper = new ModelMapper();

  @Override
  public List<BookTo> findAll() {
    List<BookEntity> books = (List<BookEntity>) bookRepository.findAll();

    return books.stream()
        .map(bookEntity -> mapper.map(bookEntity, BookTo.class))
        .collect(Collectors.toList());
  }

  @Override
  public BookTo findById(Long id) {
    return bookRepository.findById(id)
        .map(userEntity -> mapper.map(userEntity, BookTo.class))
        .orElseThrow(EntityNotFoundException::new);
  }

  @Override
  public BookTo create(BookTo bookTo) {
    validateNewBook(bookTo);

    BookEntity bookEntity = mapper.map(bookTo, BookEntity.class);

    bookRepository.save(bookEntity);

    return mapper.map(bookEntity, BookTo.class);
  }

  @Override
  public void delete(Long id) {
    BookEntity bookEntity = bookRepository.findById(id).orElse(null);

    if (bookEntity != null) {
      if (bookEntity.getReleaseDate() != null) {
        throw new ReservedBookCanNotBeDeletedException(id);
      } else {
        bookRepository.deleteById(id);
      }
    }
  }

  private void validateNewBook(BookTo book) {
    if (book.getId() != null) {
      throw new ParameterValidationException("When creating new Book, the ID should be null.");
    }
  }
}
