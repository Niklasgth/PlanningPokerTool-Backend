package com.timepoker_backend.timepoker_backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class TimepokerBackendApplication {

	public static void main(String[] args) {

		try {
			Dotenv dotenv = Dotenv.load();
			System.out.println("Loading Dotenv");
			System.setProperty("MONGO_URI", dotenv.get("MONGO_URI"));
			System.setProperty("SERVER_PORT", dotenv.get("SERVER_PORT"));
			System.setProperty("ALLOWED_ORIGINS", dotenv.get("ALLOWED_ORIGINS"));
		} catch (Exception e) {
			System.out.println("No Dotenv, not running local");
		}

		SpringApplication.run(TimepokerBackendApplication.class, args);
	}

}
