package pl.vm.library.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Transport Object of the Book class.
 */
@Data
public class BookTo implements Serializable {

	private static final long serialVersionUID = -3939153951563803292L;

	private Long id;

	@NotNull
	@Size(max = 255)
	private String author;

	@NotNull
	@Size(max = 255)
	private String title;

	@NotNull
	@Size(min = 13, max = 13)
	private String isbn;

	private Instant releaseDate;
}
