package co.edu.udemedellin.airbnb_backend.dto;

import co.edu.udemedellin.airbnb_backend.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ImageRequest {
    private Long propertyId;
    private String url;

    public ImageRequest() {}

    public ImageRequest(Image image) {
        this.propertyId = image.getProperty().getId();
        this.url = image.getUrl();
    }
}
