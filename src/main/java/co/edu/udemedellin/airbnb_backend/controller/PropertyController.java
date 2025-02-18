package co.edu.udemedellin.airbnb_backend.controller;

import co.edu.udemedellin.airbnb_backend.dto.PropertyDTO;
import co.edu.udemedellin.airbnb_backend.entity.Property;
import co.edu.udemedellin.airbnb_backend.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
@CrossOrigin(origins="*", allowedHeaders = "@")
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.findAllProperties();
    }

    @PostMapping
    @Qualifier(value = "addProperty")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        return ResponseEntity.ok(propertyService.addProperty(property));
    }

    @GetMapping("/{id}")
    @Qualifier(value = "getProperty")
    public PropertyDTO getProperty(@PathVariable Long id) {
        return propertyService.getProperty(id);
    }
}
