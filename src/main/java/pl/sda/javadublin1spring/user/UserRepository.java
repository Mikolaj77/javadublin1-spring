package pl.sda.javadublin1spring.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);

    List<User> findAll();
    List<User> findByGender (Gender gender);

    void save(User user);
}
