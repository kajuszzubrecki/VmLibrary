package pl.vm.library.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.vm.library.common.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "reservation")
@Data
public class ReservationEntity extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "book_id")
  private BookEntity book;

  @Column
  @NotNull
  private Instant fromDate;

  @Column
  @NotNull
  private Instant toDate;
}


