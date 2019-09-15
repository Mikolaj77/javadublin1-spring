package pl.sda.javadublin1spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Javadublin1SpringApplication {

	@Autowired
	private HelloBean helloBean;

	public static void main(String[] args)
	{
		SpringApplication.run(Javadublin1SpringApplication.class, args);
	}
	@PostConstruct
	public void run(){
		helloBean.hello();

	}


}
