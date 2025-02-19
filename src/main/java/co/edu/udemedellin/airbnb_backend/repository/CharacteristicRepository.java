package co.edu.udemedellin.airbnb_backend.repository;

import co.edu.udemedellin.airbnb_backend.entity.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {

}
