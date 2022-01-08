package recipes.services;

import recipes.model.User;

import java.util.Optional;

public interface UserService {
    boolean postUser(User user);

    Optional<User> getUserByEmail(String email);
}
