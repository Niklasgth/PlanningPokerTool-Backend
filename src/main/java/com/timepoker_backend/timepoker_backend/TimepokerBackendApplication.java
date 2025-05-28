package com.timepoker_backend.timepoker_backend;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TimepokerBackendApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TimepokerBackendApplication.class);

    Map<String, Object> dotenvMap = new HashMap<>();
    try {
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> dotenvMap.put(entry.getKey(), entry.getValue()));
        System.out.println("Loaded .env file successfully.");
    } catch (Exception e) {
        System.out.println("No .env file found or error loading it; assuming production environment.");
    }

    app.addInitializers((context) -> {
        if (!dotenvMap.isEmpty()) {
            ConfigurableEnvironment environment = context.getEnvironment();
            environment.getPropertySources().addFirst(new MapPropertySource("dotenvProperties", dotenvMap));
        }
    });

    app.run(args);
    }
}

