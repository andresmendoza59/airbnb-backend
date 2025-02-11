package co.edu.udemedellin.airbnb_backend.service;

import co.edu.udemedellin.airbnb_backend.dto.PropertyDTO;
import co.edu.udemedellin.airbnb_backend.entity.Property;
import co.edu.udemedellin.airbnb_backend.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }
    public List<Property> findAllProperties() {
        return propertyRepository.findAll();
    }

    public PropertyDTO getProperty(Long id) {
        Property property = propertyRepository.getReferenceById(id);
        return new PropertyDTO(property.getId(), property.getName(), property.getDescription(),
                property.getLocation(), property.getDailyPrice());
    }
}
