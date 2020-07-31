package pl.vm.library.exception;

import java.text.MessageFormat;

/**
 * Exception used when trying to operate on Entities which don't exist in the
 * Database.
 */
public class EntityWithProvidedIdNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 518405525882996153L;

	/**
	 * Throws an EntityWithProvidedIdNotFoundException with default message
	 */
	public EntityWithProvidedIdNotFoundException() {
    throw new EntityWithProvidedIdNotFoundException("The Entity with the given ID was not found.");
  }

	/**
	 * Throws an EntityWithProvidedIdNotFoundException with default message and given id
	 *
	 * @param id the id
	 */
	public EntityWithProvidedIdNotFoundException(Long id) {
    String message = MessageFormat.format("The Entity with the given {0} was not found.", id);
    throw new EntityWithProvidedIdNotFoundException(message);
  }

	/**
	 * Throws an EntityWithProvidedIdNotFoundException with given message
	 *
	 * @param message the message
	 */
	public EntityWithProvidedIdNotFoundException(String message) {
    super(message);
  }
}
