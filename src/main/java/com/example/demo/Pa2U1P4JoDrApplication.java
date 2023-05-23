package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteService;

@SpringBootApplication
public class Pa2U1P4JoDrApplication implements CommandLineRunner {

	@Autowired
	private EstudianteService estudianteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P4JoDrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// cREAR ESTUDIANTE
		Estudiante miEstudiante = new Estudiante();
		Estudiante miEstudiante2 = new Estudiante();

		miEstudiante.setNombre("Diego");
		miEstudiante.setApellido("Rivas");
		miEstudiante.setCedula("1725051146");
		miEstudiante.setFechaNacimiento(LocalDateTime.of(1997, 1, 8, 12, 12));

		miEstudiante2.setNombre("Jouse");
		miEstudiante2.setApellido("Ocapana");
		miEstudiante2.setCedula("172525516");
		miEstudiante2.setFechaNacimiento(LocalDateTime.of(2000, 6, 1, 12, 12));
		// 1.- GUARDAR ESTUDIANTE
		this.estudianteService.guardar(miEstudiante);
		this.estudianteService.guardar(miEstudiante2);

		// 5.- Imprimir reporte
		List<Estudiante> reporte = this.estudianteService.reporteDeTodos();
		System.out.println("REPORTE DE TODOS LOS ESTUDIANTES");
		for (Estudiante estu : reporte) {
			System.out.println(estu);
		}

		// 2.- Actualizar
		miEstudiante.setApellido("Haro");
		this.estudianteService.actualizar(miEstudiante);

		// 5.- Imprimir reporte
		List<Estudiante> reporte2 = this.estudianteService.reporteDeTodos();
		System.out.println("REPORTE 2 DE TODOS LOS ESTUDIANTES");
		for (Estudiante estu : reporte2) {
			System.out.println(estu);

		}

		// 3. Eliminar
		this.estudianteService.borrar("1725051146");

		// 5.- Imprimir reporte
		List<Estudiante> reporte3 = this.estudianteService.reporteDeTodos();
		System.out.println("REPORTE 2 DE TODOS LOS ESTUDIANTES");
		for (Estudiante estu : reporte3) {
			System.out.println(estu);
		}
		
		//Buscar e imprimir y otra funcionalidad donde busque la cedula que no existe
		System.out.println("//////////////");
		this.estudianteService.buscarPorCedula("0000045245");

	}

}
