package co.edu.udemedellin.airbnb_backend.controller;

import co.edu.udemedellin.airbnb_backend.entity.Characteristic;
import co.edu.udemedellin.airbnb_backend.service.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characteristics")
public class CharacteristicController {
    private final CharacteristicService characteristicService;

    public CharacteristicController(@Autowired CharacteristicService characteristicService) {
        this.characteristicService = characteristicService;
    }

    @GetMapping
    public ResponseEntity<Characteristic> getCharacteristic(@RequestBody Characteristic characteristic) {
        return ResponseEntity.ok(characteristicService.getCharacteristic(characteristic));
    }

    @PostMapping
    public ResponseEntity<Characteristic> addCharacteristic(@RequestBody Characteristic characteristic) {
        return ResponseEntity.ok(characteristicService.addCharacteristic(characteristic));
    }

    @PutMapping
    public ResponseEntity<Characteristic> updateCharacteristic(@RequestParam Long id,
                                                               @RequestBody Characteristic characteristic) {
        return ResponseEntity.ok(characteristicService.updateCharacteristic(id, characteristic));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCharacteristic(@RequestParam Long id) throws RuntimeException {
        try {
            characteristicService.deleteCharacteristic(id);
            return ResponseEntity.ok("Characteristic deleted");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Characteristic seems to not exist");
        }
    }
}
