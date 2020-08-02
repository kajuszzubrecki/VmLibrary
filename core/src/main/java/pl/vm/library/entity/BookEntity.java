package pl.vm.library.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.vm.library.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "book")
@Data
public class BookEntity extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Column
  @NotNull
  @Size(max = 255)
  private String author;

  @Column
  @NotNull
  @Size(max = 255)
  private String title;

  @Column
  @NotNull
  @Size(min = 13, max = 13)
  private String isbn;

  @Column
  private Instant releaseDate;
}
