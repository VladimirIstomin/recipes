package recipes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.entities.User;
import recipes.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean postUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return false;
        } else {
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
