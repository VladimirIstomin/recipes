package recipes.services;

import recipes.entities.User;

import java.util.Optional;

public interface UserService {
    boolean postUser(User user);

    Optional<User> getUserByEmail(String email);
}
