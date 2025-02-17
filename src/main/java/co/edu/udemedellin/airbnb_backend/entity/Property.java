package co.edu.udemedellin.airbnb_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String location;
    private double dailyPrice;

    @Override
    public String toString() {
        return String.format("Id: %d\tName: %s\tDescription: %s\tLocation: %s\tDaily Price: %f", id,
                name, description, location, dailyPrice);
    }
}