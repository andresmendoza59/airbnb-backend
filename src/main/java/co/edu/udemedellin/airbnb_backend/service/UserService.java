package co.edu.udemedellin.airbnb_backend.service;

import co.edu.udemedellin.airbnb_backend.dto.UserDTO;
import co.edu.udemedellin.airbnb_backend.entity.User;
import co.edu.udemedellin.airbnb_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserById(Long id) throws RuntimeException {
        if (userRepository.existsById(id)) {
            User user = userRepository.getReferenceById(id);
            return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
        } else {
            throw new RuntimeException("User does not exist");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists, try another one");
        }
        return userRepository.save(user);
    }
}
