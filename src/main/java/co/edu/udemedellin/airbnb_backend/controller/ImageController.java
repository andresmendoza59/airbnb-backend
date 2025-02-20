package co.edu.udemedellin.airbnb_backend.controller;

import co.edu.udemedellin.airbnb_backend.dto.ImageRequest;
import co.edu.udemedellin.airbnb_backend.entity.Image;
import co.edu.udemedellin.airbnb_backend.service.ImageService;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public ResponseEntity<ImageRequest> getImage(@RequestParam Long id) throws RuntimeException {
        return ResponseEntity.ok(imageService.getImage(id));
    }

    @GetMapping("/by-property")
    public ResponseEntity<List<ImageRequest>> getByPropertyId(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(imageService.getByPropertyId(id));
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong");
        }
    }

    @PostMapping
    public ResponseEntity<Image> addImage(@RequestBody ImageRequest imageRequest) throws RuntimeException {
        return ResponseEntity.ok(imageService.addImage(imageRequest));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteImage(@RequestParam Long id) {
        return ResponseEntity.ok(imageService.deleteImage(id));
    }
}
