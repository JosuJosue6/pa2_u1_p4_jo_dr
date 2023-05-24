package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4JoDrApplication implements CommandLineRunner {

	//@Autowired
	//private EstudianteService estudianteService;

	@Autowired
	private CuentaService cuentaService;
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// cREAR ESTUDIANTE
		Estudiante miEstudiante = new Estudiante();
		Estudiante miEstudiante2 = new Estudiante();

		//Crear cuenta
		
		Cuenta cuenta = new Cuenta();
		cuenta.setNumero("212121");
		cuenta.setTipo("Ahorros");
		
	}

}
