package pl.vm.library.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.vm.library.entity.ReservationEntity;
import pl.vm.library.exception.EntityWithProvidedIdNotFoundException;
import pl.vm.library.repository.ReservationRepository;
import pl.vm.library.service.ReservationService;
import pl.vm.library.to.ReservationTo;

import javax.transaction.Transactional;
import java.time.Instant;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

  @Autowired
  private ReservationRepository reservationRepository;

  private ModelMapper mapper = new ModelMapper();


  @Override
  public ReservationTo createNewReservation(ReservationTo reservationTo) {

    ReservationEntity reservationEntity = mapper.map(reservationTo, ReservationEntity.class);
    ReservationEntity savedEntity = reservationRepository.save(reservationEntity);

    return mapper.map(savedEntity, ReservationTo.class);
  }

  @Override
  public ReservationTo extendReservation(Long reservationId, Instant newToDate) {
    ReservationEntity reservationEntity = reservationRepository.findById(reservationId).orElse(null);

    if (reservationEntity != null) {
      reservationEntity.setToDate(newToDate);
      ReservationEntity save = reservationRepository.save(reservationEntity);
      return mapper.map(save, ReservationTo.class);
    } else {
      throw new EntityWithProvidedIdNotFoundException(reservationId);
    }
  }
}
