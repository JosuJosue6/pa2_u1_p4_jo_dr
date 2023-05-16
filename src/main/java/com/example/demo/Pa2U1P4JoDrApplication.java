package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4JoDrApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Mi primer proyecto.");
		/*Spring Framework: esto es un framework que permite la 
		construccion/desarrollo de aplicaciones empresariales basadas en spring
		*/
		Profesor p = new Profesor();
		
		p.setNombre("Diego");
		p.setApellido("Rivas");
		p.setCedula("1725051146");
		p.setFech_nacimineto(LocalDateTime.now());
		
		System.out.print(p);
		
	}

}
