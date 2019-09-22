package pl.sda.javadublin1spring.user;

import org.springframework.data.repository.CrudRepository;
import pl.sda.javadublin1spring.user.entitis.Gender;
import pl.sda.javadublin1spring.user.entitis.User;

import java.util.List;

public interface JpaUserRepository extends CrudRepository<User,Long> {
    List<User> findByGender (Gender gender);
}
