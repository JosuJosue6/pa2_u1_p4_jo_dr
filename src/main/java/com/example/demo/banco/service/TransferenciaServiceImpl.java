package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.banco.repository.CuentaRepository;
import com.example.demo.banco.repository.TransferenciaRepository;
import com.example.demo.banco.repository.modelo.Cuenta;
import com.example.demo.banco.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements TransferenciaService{

	@Autowired
	private CuentaRepository cuentaRepository;
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	@Autowired
	@Qualifier("internacional")
	private MontoDebitarService debitarService;
	
	private List<Transferencia> estado = new ArrayList<>();
	
	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.insertar(transferencia);
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.actualizar(transferencia);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.eliminar(numero);
	}

	@Override
	public  List<Transferencia> estadoCuenta(String numeroCuenta){
		// TODO Auto-generated method stub
		return estado;
	}

	@Override
	public void realizar(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
		//PROCEDEMOS A REALIZAR LA LOGICA DE NEGOCIO
		//LA LOGICA DE NEGOCIO TIENE ---->LO QUE HACE
		//--------------HISTORIA DE USUARIO------------
		//1.- Consultar la Cuenta de Origen por el Numero de Cuenta (DEBERIA REVISAR SI ESTA EL LA cUNETA SERVICE)
		//Cuando no hay logica de negocio en el Service puedo ir directo al Repository
		Cuenta ctaOrigen = this.cuentaRepository.seleccionarPorNumero(cuentaOrigen);
		//Cuenta ctaDestino = this.cuentaRepository.seleccionarPorNumero(cuentaDestino); 
		
		//2.- Consular el saldo de la Cuenta Origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		//3.- Validar si el saldo es Suficiente
		
		BigDecimal montoDebitar = this.debitarService.calcular(monto);
		
		if (montoDebitar.compareTo(saldoOrigen) <= 0) {
			System.out.println("Operacion Valida");
			
			//5.- Si es suficiente ir al paso 6
			//6.- Realizamos la resta del saldo origen - monto
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(montoDebitar);
			//7.- Actualizamos en nuevo saldo de la Cuenta Origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.cuentaRepository.actualizar(ctaOrigen);
			//8.- Consultamos la Cuenta destino por el numero
			Cuenta ctaDestino = this.cuentaRepository.seleccionarPorNumero(cuentaDestino);
			
			//9.- Consultamos el saldo de la Cuenta Destino
			BigDecimal saldoDestino= ctaDestino.getSaldo();
			
			//10.-Realizamos la suma del saldo destino + monto
			BigDecimal nuevoSaldoDestino =saldoDestino.add(monto);
			
			
			//11.-Actualizamos el nuevo saldo de la Cuenta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.cuentaRepository.actualizar(ctaDestino);
			//12.-Creamos la transferencia.
			Transferencia trasnfer = new Transferencia();
			trasnfer.setCuentaOrigen(ctaOrigen);
			trasnfer.setCuentaD(ctaDestino);
			trasnfer.setMonto(monto);
			Double numero = Math.random();
			trasnfer.setNumero(numero.toString());
			trasnfer.setFecha(LocalDateTime.now());
			this.transferenciaRepository.insertar(null);
			
			
		} else {
			//4.- Si no es sificiente imprimir mensaje de NO HAY SALDO
			System.out.println("Saldo no disponible, Su saldo es:"+saldoOrigen);
		}
			
	}
	
	

	@Override
	public Transferencia buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return null;
	}

}
