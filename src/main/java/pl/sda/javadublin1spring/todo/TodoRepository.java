package pl.sda.javadublin1spring.todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Optional<Todo> findById (Long id);
    List<Todo> findAll ();
    List<Todo> findByStatus(TodoStatus status);
}
