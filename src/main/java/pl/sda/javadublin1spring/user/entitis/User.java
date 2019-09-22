package pl.sda.javadublin1spring.user.entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private  String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany
    private List<Address> address;

    public String getFullName(){
        return firstName + "  " + lastName;
    }
}
