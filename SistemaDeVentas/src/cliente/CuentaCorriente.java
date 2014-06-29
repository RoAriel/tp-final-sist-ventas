package cliente;

import java.util.ArrayList;
import java.util.List;

import exceptionVenta.SaldoInsuficienteCtaCteException;

public class CuentaCorriente {
	private Double saldo;
	private Cliente propietario;
	private List<String> movimientos;

	public CuentaCorriente(Cliente propietario) {
		this.saldo= 0.0d;
		this.propietario=propietario;
		this.movimientos = new ArrayList<String>();
	}

		
	private Cliente getPropietario() {
		return propietario;
	}

	public Double saldo() {
		return saldo;
	}

	private void setSaldo(Double saldo) {
		this.saldo = saldo;
	};

	private List<String> getMovimientos() {
		return movimientos;
	}

	/**
	 * Se le agrega monto a la cuenta corriente.
	 * @param monto
	 */
	public void depositar(Double monto){
		this.setSaldo(this.saldo()+monto);
		this.registrarDeposito(monto);
	}
	
	private boolean saldoSuficiente(Double unMonto){
		return this.saldo()>=unMonto;
	}
	
	/**
	 * Decrementa monto de la cuenta corriente.
	 * @param monto
	 */
	public void abonar(Double monto) throws SaldoInsuficienteCtaCteException{
		if (this.saldoSuficiente(monto)){
			this.setSaldo(saldo()-monto);
			this.notificarMovimiento("Se debitaron "+this.saldo()+" pesos de su cuenta corriente.");
			this.registrarPago(monto);
		}else{
			throw new SaldoInsuficienteCtaCteException();
		}
	}
	
	/**
	 * Agrega al registro interno el deposito que se realizo.
	 * @param cantidad cantidad que se deposito
	 */
	private void registrarDeposito(Double cantidad){
		String nuevoMovimiento = "Se depositaron "+cantidad+" pesos en la cuenta corriente.";
		this.getMovimientos().add(nuevoMovimiento);
	}
	
	/**
	 * Agrega al registro interno la cantidad que se extrajo.
	 * @param cantidad cantidad que se extrajo
	 */
	private void registrarPago(Double cantidad){
		String nuevoMovimiento = "Se extrajo "+cantidad+" pesos en la cuenta corriente.";
		this.getMovimientos().add(nuevoMovimiento);
	}
	
	/**
	 * Notifica al propietario de la CuentaCorriente sobre el movimiento.
	 * @param arg
	 */
	private void notificarMovimiento(String arg){
		this.getPropietario().notificacion(arg);
		//notificar al cliente sobre el movimiento
	}
}
