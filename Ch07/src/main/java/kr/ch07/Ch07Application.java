package kr.ch07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //component Scan annotation
public class Ch07Application {

	// JAVA처럼 실행함
	public static void main(String[] args) {
		SpringApplication.run(Ch07Application.class, args);
		
		System.out.println("Hello Spring Boot!");
	}

}
