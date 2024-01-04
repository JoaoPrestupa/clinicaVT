package br.com.clinicavt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

@SpringBootApplication
public class App {

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	private void starter(){
		System.out.println();
		System.out.println();
		System.out.println("App Started at " + LocalDateTime.now());
		System.out.println();
	}

}
