package pl.vm.library.exception;

import java.text.MessageFormat;

/**
 * The type Reserved book can not be deleted.
 */
public class ReservedBookCanNotBeDeletedException extends RuntimeException {

	private static final long serialVersionUID = -779041494072937362L;

	/**
	 * Throws an exception that gaven book id is already reserved and can not be deleted
	 *
	 * @param id the id
	 */
	public ReservedBookCanNotBeDeletedException(Long id) {
		String message = MessageFormat.format("Book with id: {0} is reserved and can not be deleted", id);
		throw new EntityWithProvidedIdNotFoundException(message);
	}
}
