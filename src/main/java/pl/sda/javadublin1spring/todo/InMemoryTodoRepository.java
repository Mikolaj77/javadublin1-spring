package pl.sda.javadublin1spring.todo;

import org.springframework.stereotype.Repository;
import pl.sda.javadublin1spring.user.InMemoryUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Repository
public class InMemoryTodoRepository implements TodoRepository {
    private List<Todo> todoList;


    public InMemoryTodoRepository() {
        this.todoList = new ArrayList<>();
    }

    InMemoryTodoRepository(List<Todo> todos) {
        this.todoList = new ArrayList<>(todos);
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return todoList.stream()
                .filter(todo -> id.equals(todo.getId()))
                .findFirst();
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public List<Todo> findByStatus(TodoStatus status) {
        return todoList.stream()
                .filter(todo -> status.equals(todo.getStatus()))
                .collect(Collectors.toList());
    }
}
