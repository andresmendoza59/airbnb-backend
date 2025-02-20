package co.edu.udemedellin.airbnb_backend.controller;

import co.edu.udemedellin.airbnb_backend.dto.DestinyDTO;
import co.edu.udemedellin.airbnb_backend.entity.Destiny;
import co.edu.udemedellin.airbnb_backend.service.DestinyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destinies")
public class DestinyController {
    private final DestinyService destinyService;

    public DestinyController(DestinyService destinyService) {
        this.destinyService = destinyService;
    }

    @GetMapping
    public DestinyDTO getDestiny(@RequestParam Long id) {
        return destinyService.getDestiny(id);
    }

    @PostMapping
    public Destiny addDestiny(@RequestBody Destiny destiny) {
        return destinyService.addDestiny(destiny);
    }

    @PutMapping
    public Destiny updateDestiny(@RequestParam Long id, @RequestBody Destiny destiny) {
        return destinyService.updateDestiny(id, destiny);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDestiny(@RequestParam Long id) throws RuntimeException {
        return ResponseEntity.ok(destinyService.deleteDestiny(id));
    }
}
