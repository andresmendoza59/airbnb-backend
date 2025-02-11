package co.edu.udemedellin.airbnb_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PropertyDTO {
    private Long id;
    private String name;
    private String description;
    private String location;
    private double dailyPrice;
}
