package pl.sda.javadublin1spring.user;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Primary
@Component
public class InMemoryUserRepository implements UserRepository{
    private List<User> users;
    private RepositoryHelper repositoryHelper;
    private int nextId;

    @Autowired
    public InMemoryUserRepository(){
        this.users = new ArrayList<>();
        this.repositoryHelper = repositoryHelper;
        this.nextId = 1;

    }

    InMemoryUserRepository(List<User> users) {
        this.users = users;
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id == null || id <= 0){
            throw new IllegalArgumentException();
        }
        return users.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public List<User> findByGender(Gender gender) {
        return users.stream()
                .filter(user -> gender.equals(user.getGender()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        user.setId((long) nextId++);
        users.add(user);

    }

    @PostConstruct
    private void init() {
        if (users.size() == 0) {
            save(new User(1L, "Szymon", "Nowak", Gender.MALE));
            save(new User(2L, "Jan", "Kowalski", Gender.MALE));
            save(new User(3L, "Anna", "Wiśniewska", Gender.FEMALE));
            save(new User(4L, "Karolina", "Nowak", Gender.FEMALE));

        }
    }
}
