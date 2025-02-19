package co.edu.udemedellin.airbnb_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "destinies")
public class Destiny {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;
}
