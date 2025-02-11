package co.edu.udemedellin.airbnb_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CreateReservationDTO {
    private Long guestId;
    private Long propertyId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
