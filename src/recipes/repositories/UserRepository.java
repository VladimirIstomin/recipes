package recipes.repositories;

import org.springframework.data.repository.CrudRepository;
import recipes.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
