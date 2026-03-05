package com.fabiocoral.workshopmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkshopmongoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WorkshopmongoApplication.class);
		app.setDefaultProperties(
				java.util.Map.of("spring.data.mongodb.database", "Workshop_mongo")
		);
		app.run(args);
	}
}
