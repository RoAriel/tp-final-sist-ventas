package cliente;

import java.util.ArrayList;
import java.util.List;

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



	private void setPropietario(Cliente propietario) {
		this.propietario = propietario;
	}

	private Double getSaldo() {
		return saldo;
	}

	private void setSaldo(Double saldo) {
		this.saldo = saldo;
	};

	private List<String> getMovimientos() {
		return movimientos;
	}

	private void setMovimientos(List<String> movimientos) {
		this.movimientos = movimientos;
	}


	/**
	 * Proposito: Se le agrega monto a la cuenta corriente.
	 * @param monto
	 */
	public void depositar(Double monto){
		this.setSaldo(this.getSaldo()+monto);
		this.registrarDeposito(monto);
	}
	
	/**
	 * Porposito: Decrementa monto de la cuenta corriente.
	 * @param monto
	 */
	public void abonar(Double monto){
		this.setSaldo(getSaldo()-monto);
		this.notificarMovimiento("Se debitaron "+this.getSaldo()+" pesos de su cuenta corriente.");
		this.registrarPago(monto);
	}
	
	private void registrarDeposito(Double cantidad){
		String nuevoMovimiento = "Se depositaron "+cantidad+" pesos en la cuenta corriente.";
		this.getMovimientos().add(nuevoMovimiento);
	}
	
	private void registrarPago(Double cantidad){
		String nuevoMovimiento = "Se extrajo "+cantidad+" pesos en la cuenta corriente.";
		this.getMovimientos().add(nuevoMovimiento);
	}
	
	private void notificarMovimiento(String arg){
		this.getPropietario().notificacion(arg);
		//notificar al cliente sobre el movimiento
	}
}
