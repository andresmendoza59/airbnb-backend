package co.edu.udemedellin.airbnb_backend.service;

import co.edu.udemedellin.airbnb_backend.entity.Characteristic;
import co.edu.udemedellin.airbnb_backend.repository.CharacteristicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacteristicService {
    private final CharacteristicRepository characteristicRepository;

    public CharacteristicService(@Autowired CharacteristicRepository characteristicRepository) {
        this.characteristicRepository = characteristicRepository;
    }

    public Characteristic addCharacteristic(Characteristic characteristic) {
        return characteristicRepository.save(characteristic);
    }

    public Characteristic getCharacteristic(String iconUrl) {
        return characteristicRepository.findByIconUrl(iconUrl);
    }

    public void deleteCharacteristic(Long id) throws RuntimeException {
        try {
            Characteristic characteristic = characteristicRepository.getReferenceById(id);
            characteristicRepository.delete(characteristic);
        } catch (RuntimeException e) {
            e.getCause();
            throw new RuntimeException("Characteristic seems to not exist");
        }

    }

    public Characteristic updateCharacteristic(Long oldCharacteristicId, Characteristic newCharacteristic) {
        Characteristic characteristic = characteristicRepository.getReferenceById(oldCharacteristicId);
        characteristic.setName(newCharacteristic.getName());
        characteristic.setIconUrl(newCharacteristic.getIconUrl());
        return characteristicRepository.save(characteristic);
    }
}
