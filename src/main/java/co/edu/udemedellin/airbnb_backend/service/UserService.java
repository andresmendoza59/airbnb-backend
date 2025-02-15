package co.edu.udemedellin.airbnb_backend.service;

import co.edu.udemedellin.airbnb_backend.dto.UserDTO;
import co.edu.udemedellin.airbnb_backend.entity.User;
import co.edu.udemedellin.airbnb_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static co.edu.udemedellin.airbnb_backend.entity.Role.GUEST;

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
            return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), GUEST);
        } else {
            throw new RuntimeException("User does not exist");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
