package co.edu.udemedellin.airbnb_backend.dto;

import co.edu.udemedellin.airbnb_backend.entity.Destiny;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DestinyDTO {
    private Long id;
    private String name;

    public DestinyDTO(Destiny destiny) {
        this.id = destiny.getId();
        this.name = destiny.getName();
    }
    public DestinyDTO() {}
}
