package pl.sda.javadublin1spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloBean {

    public void hello() {
        System.out.println("Hello World from hello method ");
    }
    @PostConstruct
    public void init() {
        System.out.println("Messade from HelloBean postConstruck");
    }
}
