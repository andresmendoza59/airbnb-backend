package co.edu.udemedellin.airbnb_backend.service;

import co.edu.udemedellin.airbnb_backend.dto.ImageRequest;
import co.edu.udemedellin.airbnb_backend.entity.Image;
import co.edu.udemedellin.airbnb_backend.entity.Property;
import co.edu.udemedellin.airbnb_backend.repository.ImageRepository;
import co.edu.udemedellin.airbnb_backend.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final PropertyRepository propertyRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository, PropertyRepository propertyRepository) {
        this.imageRepository = imageRepository;
        this.propertyRepository = propertyRepository;
    }

    public ImageRequest getImage(Long id) {
        try {
            Image image = imageRepository.getReferenceById(id);
            return new ImageRequest(image);
        } catch (RuntimeException e) {
            e.getCause();
            throw new RuntimeException("Image does not exist");
        }
    }

    public Image addImage(ImageRequest imageRequest) {
        if (imageRepository.existsByUrl(imageRequest.getUrl())) throw new RuntimeException("URL is already used");
        Image image = new Image();
        Property property = propertyRepository.getReferenceById(imageRequest.getPropertyId());
        image.setProperty(property);
        image.setUrl(imageRequest.getUrl());
        return imageRepository.save(image);
    }

    public String deleteImage(Long id) throws RuntimeException {
        try {
            imageRepository.delete(imageRepository.getReferenceById(id));
            return "Image deleted";
        } catch (RuntimeException e) {
            throw new RuntimeException("Image does not exist");
        }
    }
}
