package pl.sda.javadublin1spring.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private Long id;
    private String firstName;
    private  String lastName;
    private  Gender gender;

    public String getFullName(){
        return firstName + "  " + lastName;
    }
}
