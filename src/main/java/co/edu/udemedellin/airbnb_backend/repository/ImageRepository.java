package co.edu.udemedellin.airbnb_backend.repository;

import co.edu.udemedellin.airbnb_backend.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    boolean existsByUrl(String url);
    boolean existsByPropertyId(Long id);
    List<Image> getByPropertyId(Long id);
}
