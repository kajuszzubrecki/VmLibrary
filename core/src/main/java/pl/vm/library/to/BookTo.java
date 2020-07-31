package pl.vm.library.to;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Transport Object of the Book class.
 */
@Getter
@Setter
@EqualsAndHashCode
public class BookTo implements Serializable {

  private static final long serialVersionUID = -3939153951563803292L;

  private Long id;
/*
	@NotNull
	@Size(max = 255)
	private String author;

	@NotNull
	@Size(max = 255)
	private String title;

	@NotNull
	@Size(min = 13, max = 13)
	private String isbn;

	private Instant releaseDate;*/
}
