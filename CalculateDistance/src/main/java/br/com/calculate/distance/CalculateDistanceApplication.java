package br.com.calculate.distance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync 
public class CalculateDistanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculateDistanceApplication.class, args);
	}

}
