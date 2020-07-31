package pl.vm.library.repository;

import org.springframework.data.repository.CrudRepository;

import pl.vm.library.entity.BookEntity;

/**
 * The interface Book repository.
 */
public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
