package pl.vm.library.facade;

import pl.vm.library.to.ReservationTo;

import java.util.List;

public interface User {

  Long getId();

  void setId(Long id);

  String getName();

  void setName(String name);

  String getLastName();

  void setLastName(String lastName);

  String getEmail();

  void setEmail(String email);

  List<ReservationTo> getReservations();

  void setReservations(List<ReservationTo> reservations);

  String getPassword();

  void setPassword(String password);
}
