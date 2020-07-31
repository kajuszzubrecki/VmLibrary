package pl.vm.library.repository;

import org.springframework.data.repository.CrudRepository;
import pl.vm.library.entity.ReservationEntity;

/**
 * The interface Reservation repository.
 */
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

}
