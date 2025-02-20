package co.edu.udemedellin.airbnb_backend.service;

import co.edu.udemedellin.airbnb_backend.dto.PropertyDTO;
import co.edu.udemedellin.airbnb_backend.entity.Property;
import co.edu.udemedellin.airbnb_backend.repository.ImageRepository;
import co.edu.udemedellin.airbnb_backend.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository, ImageRepository imageRepository) {
        this.propertyRepository = propertyRepository;
        this.imageRepository = imageRepository;
    }

    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }
    public List<PropertyDTO> findAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        List<PropertyDTO> propertyDTOs = new ArrayList<>(properties.size());
        for (Property property: properties) {
            propertyDTOs.add(new PropertyDTO(property));
        }
        return propertyDTOs;
    }

    public PropertyDTO getProperty(Long id) {
        Property property = propertyRepository.getReferenceById(id);
        return new PropertyDTO(property);
    }
}
