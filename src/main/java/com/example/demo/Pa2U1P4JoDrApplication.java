package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.repository.modelo.Cajero;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Impuesto;
import com.example.demo.banco.repository.modelo.Presidente;
import com.example.demo.banco.repository.modelo.Transferencia;
import com.example.demo.banco.service.CargaSistemaService;
import com.example.demo.banco.service.CuentaService;
import com.example.demo.banco.service.TransferenciaService;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4JoDrApplication implements CommandLineRunner {

	//@Autowired
	//private EstudianteService estudianteService;
	
	@Autowired
	private Cajero cajero;
	
	@Autowired
	private Cajero cajero1;
	
	@Autowired
	private Presidente presidente;
	
	@Autowired
	private Presidente presidente1;
	
	@Autowired
	private CargaSistemaService cargaSistemaService;
		
	@Autowired
	private TransferenciaService transferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		this.cajero.setApellido("Ocapana");
		this.cajero.setNombre("Josue");
		this.cajero.setSalario(new BigDecimal(1000));
		
		this.cajero1.setApellido("Rivas");
		this.cajero.setNombre("Diego");
		this.cajero1.setSalario(new BigDecimal(1000));
		
		this.presidente.setApellido("Lasso");
		this.presidente.setNombre("Guillermo");
		this.presidente.setCedula("123456789");
		this.presidente1.setApellido("Toro");
		
		System.out.println(this.cajero);
		System.out.println(this.cajero1);
		System.out.println(this.cajero1.getApellido());
		System.out.println(this.presidente);
		System.out.println(this.presidente1);
		
		System.out.println("\n||||°°°°°°°°SEGUNDA PARTE*°°°°°||||");
		this.cargaSistemaService.cargar();
		Transferencia transferencia = new Transferencia();
		transferencia.setCuentaD(null);
		transferencia.setCuentaOrigen(null);
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(new BigDecimal(12134));
		transferencia.setNumero("123");
		this.transferenciaService.guardar(transferencia);

	}

}
