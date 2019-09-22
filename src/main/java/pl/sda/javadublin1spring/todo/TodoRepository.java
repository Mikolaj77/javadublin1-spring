package pl.sda.javadublin1spring.todo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByStatus(TodoStatus status);
}
