package co.edu.udemedellin.airbnb_backend.dto;

import co.edu.udemedellin.airbnb_backend.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ReservationDTO {
    private Long id;
    private Long guestId;
    private Long propertyId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public ReservationDTO(Reservation reservation) {
        this.id = reservation.getId();
        this.propertyId = reservation.getProperty().getId();
        this.guestId = reservation.getGuest().getId();
        this.checkInDate = reservation.getCheckInDate();
        this.checkOutDate = reservation.getCheckOutDate();
    }
}
