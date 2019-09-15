package pl.sda.javadublin1spring.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class UserService {                      // klasa service opowiada za trzymanie logiki naszej domeny (czesto publiczna)
    private UserRepository userRepository;      //pole


    public UserService(@Qualifier("fileBasedUserRepository") UserRepository userRepository) {  // konstruktor
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


}
