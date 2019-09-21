package pl.sda.javadublin1spring.user;

import org.springframework.data.repository.CrudRepository;

public interface JpaUserRepository extends CrudRepository<User,Long> {
}
