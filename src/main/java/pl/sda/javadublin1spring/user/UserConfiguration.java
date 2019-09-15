package pl.sda.javadublin1spring.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class UserConfiguration {
    @Bean
    public  UserRepository preInitializedInMemoryUserRepository(){
        return new InMemoryUserRepository(Arrays.asList(
                new User (1L, "Jan", "Kowalski", Gender.MALE)));

    }
}
