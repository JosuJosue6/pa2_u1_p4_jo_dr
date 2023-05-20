package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P4JoDrApplication implements CommandLineRunner{

	@Autowired //Anotacion de inyeccion
	private Profesor profe2;
	
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
		
		System.out.println(p);
	
		profe2 = new Profesor();
		profe2.setApellido("Ocapana");
		System.out.println(profe2);
		/*
		Profesor profe3;
		profe3 =p;
		System.out.println(profe3);
		p.setApellido("GGGGG");
		System.out.println(profe3);
		profe3.setApellido("77777");
		System.out.println(profe3);
		*/
		MatriculaCalculo mat = new MatriculaCalculo();
		mat.realizarMatricula("1");
		
		
		//System.out.println(profe2.getApellido()); error porque quiero acceder a algo que es NULL
		// null pointer exception --> estas queriendo acceder a un atributo de null
	}

}
