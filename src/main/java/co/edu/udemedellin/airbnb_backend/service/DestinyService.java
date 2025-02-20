package co.edu.udemedellin.airbnb_backend.service;

import co.edu.udemedellin.airbnb_backend.dto.DestinyDTO;
import co.edu.udemedellin.airbnb_backend.entity.Destiny;
import co.edu.udemedellin.airbnb_backend.repository.DestinyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinyService {
    private final DestinyRepository destinyRepository;

    public DestinyService(@Autowired DestinyRepository destinyRepository) {
        this.destinyRepository = destinyRepository;
    }

    public DestinyDTO getDestiny(Long id) {
        Destiny destiny = destinyRepository.getReferenceById(id);
        return new DestinyDTO(destiny);
    }

    public Destiny addDestiny(Destiny destiny) {
        return destinyRepository.save(destiny);
    }

    public Destiny updateDestiny(Long id, Destiny newDestiny) throws RuntimeException {
        try {
            Destiny destiny = destinyRepository.getReferenceById(id);
            destiny.setName(newDestiny.getName());
            return destinyRepository.save(destiny);
        } catch (RuntimeException e) {
            e.getCause();
            throw new RuntimeException("Destiny seems to not exist");
        }
    }

    public String deleteDestiny(Long id) throws RuntimeException {
        try {
            destinyRepository.delete(destinyRepository.getReferenceById(id));
            return "Destiny deleted successfully";
        } catch (RuntimeException e) {
            throw new RuntimeException("Destiny doesn't exist");
        }
    }
}
