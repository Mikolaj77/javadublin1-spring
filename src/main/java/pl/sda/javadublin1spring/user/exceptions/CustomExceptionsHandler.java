package pl.sda.javadublin1spring.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice   // jezeli w aplikacje polecial wyjatek to go wylapmy i obsluzmy
public class CustomExceptionsHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleUserNotFound(UserNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("errors/not-found");
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;

    }
    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)   //ustawianie kodu odpowiedzi
    public ModelAndView handleInvalidParameterException(InvalidParameterException e) {
        ModelAndView modelAndView = new ModelAndView("errors/bad-request");
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;
    }
}
