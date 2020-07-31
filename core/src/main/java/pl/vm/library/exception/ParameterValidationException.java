package pl.vm.library.exception;

/**
 * Exception used when operations are tried to made with wrong input parameters.
 */
public class ParameterValidationException extends RuntimeException {

  private static final long serialVersionUID = -779041494072937362L;

  /**
   * Throws ParameterValidationException with default message
   */
  public ParameterValidationException() {
    super("One of the input parameters is not correct");
  }

  /**
   * Throws ParameterValidationException with given message
   */
  public ParameterValidationException(String message) {
    super(message);
  }
}
