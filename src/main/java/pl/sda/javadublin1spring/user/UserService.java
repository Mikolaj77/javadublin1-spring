package pl.sda.javadublin1spring.user;

import org.springframework.stereotype.Component;
import pl.sda.javadublin1spring.user.exceptions.InvalidParameterException;
import pl.sda.javadublin1spring.user.exceptions.UserNotFoundException;

import java.util.List;

@Component

public class UserService {                      // klasa service opowiada za trzymanie logiki naszej domeny (czesto publiczna)
    private UserRepository userRepository;      //pole


    public UserService(UserRepository userRepository) {  // konstruktor
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    public List<User> findAll() {
        return userRepository.findAll();

    }public List<User> findByGender(String gender) {
        try {


            Gender enumGender = Gender.valueOf(gender);
            return  userRepository.findByGender(enumGender);
        } catch (IllegalArgumentException e) {
            throw  new InvalidParameterException( "gender");


        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
