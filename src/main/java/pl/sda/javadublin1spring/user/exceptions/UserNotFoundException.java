package pl.sda.javadublin1spring.user.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {

        super("User with id" + id + " not found");
    }
}
