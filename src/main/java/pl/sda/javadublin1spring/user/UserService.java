package pl.sda.javadublin1spring.user;

import org.springframework.stereotype.Component;
import pl.sda.javadublin1spring.user.entitis.Gender;
import pl.sda.javadublin1spring.user.entitis.User;
import pl.sda.javadublin1spring.user.exceptions.InvalidParameterException;
import pl.sda.javadublin1spring.user.exceptions.UserNotFoundException;

import java.util.List;

@Component
public class UserService {                      // klasa service opowiada za trzymanie logiki naszej domeny (czesto publiczna)

    private JpaUserRepository jpaUserRepository;   //pole

    private UserService( JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    public User findById(Long id) {
        return jpaUserRepository.findById(id)  // zmiana z userRepository na jpaUserRepository
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    public Iterable<User> findAll() {
        return jpaUserRepository.findAll(); // zmiana z userRepository na jpaUserRepository

    }

    public List<User> findByGender(String gender) {
        try {
            Gender enumGender = Gender.valueOf(gender);
            return jpaUserRepository.findByGender(enumGender);
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException("gender");

        }
    }

    public void saveUser(User user) {
        jpaUserRepository.save(user);  // zmiana z userRepository na jpaUserRepository
    }
}
