package pl.vm.library.to;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Transport Object of the Reservation class.
 */
@Entity
@EqualsAndHashCode
public class ReservationTo implements Serializable {

	private static final long serialVersionUID = -60690548233543094L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private UserTo userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// TODO You can add fields which you need to finish the task.

}