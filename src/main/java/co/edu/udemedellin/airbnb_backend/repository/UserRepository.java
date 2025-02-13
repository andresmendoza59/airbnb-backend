package co.edu.udemedellin.airbnb_backend.repository;

import co.edu.udemedellin.airbnb_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
