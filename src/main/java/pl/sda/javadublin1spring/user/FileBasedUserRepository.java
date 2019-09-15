package pl.sda.javadublin1spring.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FileBasedUserRepository implements UserRepository {

     private RepositoryHelper repositoryHelper;
     public  FileBasedUserRepository(RepositoryHelper repositoryHelper) {
         this.repositoryHelper = repositoryHelper;
     }
    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void save(User user) {

    }
}
