package pl.vm.library.entity;

import lombok.Data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	@NotNull
	@Size(max = 255)
	private String name;

	@Column
	@NotNull
	@Size(max = 255)
	private String lastName;

	@NotNull
	@Email
	@Size(max = 255)
	@Column
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Reservation> reservations;
}
