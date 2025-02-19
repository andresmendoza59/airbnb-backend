package co.edu.udemedellin.airbnb_backend.repository;

import co.edu.udemedellin.airbnb_backend.entity.Destiny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinyRepository extends JpaRepository<Destiny, Long> {
}
