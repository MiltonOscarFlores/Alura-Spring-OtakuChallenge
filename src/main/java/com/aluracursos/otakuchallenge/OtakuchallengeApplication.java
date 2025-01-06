package com.aluracursos.otakuchallenge;

import com.aluracursos.otakuchallenge.principal.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Principal;

@SpringBootApplication
public class OtakuchallengeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OtakuchallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.MostrarMenu();
	}
}
