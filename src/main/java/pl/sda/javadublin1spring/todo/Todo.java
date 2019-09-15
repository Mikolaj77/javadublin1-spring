package pl.sda.javadublin1spring.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private Long id;
    private  String name;
    private  String description;
    private  TodoStatus status;

}
