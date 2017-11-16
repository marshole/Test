package com.wxh.note.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
        //app.addListeners(new MyApplicationStartedEventListener());
        app.run(args);
    }
}
