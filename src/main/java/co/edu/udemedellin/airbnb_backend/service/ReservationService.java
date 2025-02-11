package co.edu.udemedellin.airbnb_backend.service;

import co.edu.udemedellin.airbnb_backend.dto.CreateReservationDTO;
import co.edu.udemedellin.airbnb_backend.dto.ReservationDTO;
import co.edu.udemedellin.airbnb_backend.entity.Reservation;
import co.edu.udemedellin.airbnb_backend.repository.PropertyRepository;
import co.edu.udemedellin.airbnb_backend.repository.ReservationRepository;
import co.edu.udemedellin.airbnb_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final PropertyRepository propertyRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository,
                              PropertyRepository propertyRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.propertyRepository = propertyRepository;
    }

    @Transactional
    public ReservationDTO createReservation(CreateReservationDTO reservationDto) throws RuntimeException {
        if (isValidForReservation(reservationDto)) {
            Reservation reservation = new Reservation();
            reservation.setGuest(userRepository.getReferenceById(reservationDto.getGuestId()));
            reservation.setProperty(propertyRepository.getReferenceById(reservationDto.getPropertyId()));
            reservation.setCheckInDate(reservationDto.getCheckInDate());
            reservation.setCheckOutDate(reservationDto.getCheckOutDate());
            reservationRepository.save(reservation);
            return new ReservationDTO(reservation);
        } else {
            throw new RuntimeException("Guest does not exist in the database or dates' order is incorrect");
        }
    }
    public ReservationDTO requestReservation(Long id) {
        Reservation reservation = reservationRepository.getReferenceById(id);
        return new ReservationDTO(reservation.getId(), reservation.getGuest().getId(),
                reservation.getProperty().getId(), reservation.getCheckInDate(), reservation.getCheckOutDate());
    }

    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationDTO> reservationDTOs = new ArrayList<>(reservations.size());
        for (Reservation reservation: reservations) {
            reservationDTOs.add(new ReservationDTO(reservation));
        }
        return reservationDTOs;
    }

    public boolean isValidForReservation(CreateReservationDTO reservationDto) {
        return userRepository.existsById(reservationDto.getGuestId()) &&
                propertyRepository.existsById(reservationDto.getPropertyId()) &&
                reservationDto.getCheckInDate().isBefore(reservationDto.getCheckOutDate());
    }
}
