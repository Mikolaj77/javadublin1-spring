package pl.sda.javadublin1spring.user;

import org.springframework.stereotype.Component;
import pl.sda.javadublin1spring.user.exceptions.InvalidParameterException;
import pl.sda.javadublin1spring.user.exceptions.UserNotFoundException;

import java.util.List;

@Component
public class UserService {                      // klasa service opowiada za trzymanie logiki naszej domeny (czesto publiczna)
    private UserRepository userRepository;  //pole
    private JpaUserRepository jpaUserRepository;

    private UserService(UserRepository userRepository, JpaUserRepository jpaUserRepository) {
        this.userRepository = userRepository;
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
            return userRepository.findByGender(enumGender);
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException("gender");

        }
    }

    public void saveUser(User user) {
        jpaUserRepository.save(user);  // zmiana z userRepository na jpaUserRepository
    }
}
