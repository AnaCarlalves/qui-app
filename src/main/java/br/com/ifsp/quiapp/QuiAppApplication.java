package br.com.ifsp.quiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuiAppApplication {

	public static void main(String[] args) {
		DatabasePergunta.init();
		SpringApplication.run(QuiAppApplication.class, args);
	}

}
