package co.edu.udemedellin.airbnb_backend.controller;

import co.edu.udemedellin.airbnb_backend.dto.PropertyDTO;
import co.edu.udemedellin.airbnb_backend.entity.Property;
import co.edu.udemedellin.airbnb_backend.service.PropertyService;
import co.edu.udemedellin.airbnb_backend.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    private final PropertyService propertyService;
    private final S3Service s3Service;

    @Autowired
    public PropertyController(PropertyService propertyService, S3Service s3Service) {
        this.propertyService = propertyService;
        this.s3Service = s3Service;
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

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadImage(@RequestParam("file")MultipartFile file) {
//        try {
//            String imageUrl = s3Service.uploadFile(file);
//            return ResponseEntity.ok(imageUrl);
//        } catch (IOException e) {
//            return ResponseEntity.status(500).body("Failed to upload image");
//        }
//    }
}
