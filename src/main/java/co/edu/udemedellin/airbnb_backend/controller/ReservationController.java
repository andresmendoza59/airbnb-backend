package co.edu.udemedellin.airbnb_backend.controller;

import co.edu.udemedellin.airbnb_backend.dto.CreateReservationDTO;
import co.edu.udemedellin.airbnb_backend.dto.ReservationDTO;
import co.edu.udemedellin.airbnb_backend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins="*", allowedHeaders = "@")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> reserveProperty(@RequestBody CreateReservationDTO reservationDto) {
        return ResponseEntity.ok(reservationService.createReservation(reservationDto));
    }

    @GetMapping("/{id}")
    public ReservationDTO requestReservation(@PathVariable Long id) {
        return reservationService.requestReservation(id);
    }

    @GetMapping
    public List<ReservationDTO> getAllReservations() {
        return reservationService.getAllReservations();
    }
}
