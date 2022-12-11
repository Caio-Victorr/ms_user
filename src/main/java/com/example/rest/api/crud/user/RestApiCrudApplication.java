package com.example.rest.api.crud.user;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RestApiCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiCrudApplication.class, args);
	}

}
