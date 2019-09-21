package pl.sda.javadublin1spring.user.exceptions;

public class InvalidParameterException extends  RuntimeException {
    public InvalidParameterException(String parameter) {
        super("Invalid value of parameter: " + parameter );
    }
}
