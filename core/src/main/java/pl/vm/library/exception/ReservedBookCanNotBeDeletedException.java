package pl.vm.library.exception;

import java.text.MessageFormat;
import java.util.EmptyStackException;

/**
 * The type Reserved book can not be deleted.
 */
public class ReservedBookCanNotBeDeletedException extends RuntimeException {

  private static final long serialVersionUID = -779041494072937362L;

  /**
   * Throws an exception that gaven book id is already reserved and can not be deleted
   *
   */
  public ReservedBookCanNotBeDeletedException() {
    throw new EmptyStackException();
  }

  /**
   * Throws an EntityWithProvidedIdNotFoundException with given message
   *
   * @param message the message
   */
  public ReservedBookCanNotBeDeletedException(String message) {
    super(message);
  }

  public ReservedBookCanNotBeDeletedException(Long id) {
    String message = MessageFormat.format("The Book with the given id: {0} is reserved and cannot be deleted", id);
    throw new ReservedBookCanNotBeDeletedException(message);
  }

}
