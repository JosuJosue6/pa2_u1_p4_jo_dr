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

import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;
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

		Cuenta cuenta1 = new Cuenta();
		cuenta1.setCedulaPropietario("1234");
		cuenta1.setFechaApertura(LocalDate.now());
		cuenta1.setNumero("666");
		cuenta1.setSaldo(new BigDecimal(200));
		cuenta1.setTipo("A");
		this.cuentaService.guardar(cuenta1);
		//-----------------------------------
		Cuenta cuenta2 = new Cuenta();
		cuenta2.setCedulaPropietario("998844");
		cuenta2.setFechaApertura(LocalDate.now());
		cuenta2.setNumero("111");
		cuenta2.setSaldo(new BigDecimal(100));
		cuenta2.setTipo("A");
		this.cuentaService.guardar(cuenta2);
		
		//---------------------------------------
		this.transferenciaService.realizar("666", "111", new BigDecimal(50));
		System.out.println("SALDO ORIGEN: "+ this.cuentaService.seleccionar("666").getSaldo());
		System.out.println("SALDO DESTINO: "+this.cuentaService.seleccionar("111").getSaldo());
		
		
	}

}
