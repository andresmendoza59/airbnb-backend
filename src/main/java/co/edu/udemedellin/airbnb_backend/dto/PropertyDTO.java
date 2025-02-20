package co.edu.udemedellin.airbnb_backend.dto;

import co.edu.udemedellin.airbnb_backend.entity.Property;
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
    private boolean isExperience;

    public PropertyDTO(Property property) {
        this.id = property.getId();
        this.name = property.getName();
        this.description = property.getDescription();
        this.location = property.getLocation();
        this.dailyPrice = property.getDailyPrice();
        this.isExperience = property.isExperience();
    }
    public PropertyDTO() {}
}
