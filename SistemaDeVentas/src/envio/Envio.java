package envio;

import org.joda.time.DateTime;

import venta.Venta;
import cliente.Cliente;
import exceptions.CanceladoException;
import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;
import exceptions.SaldoInsuficienteCtaCteException;

public class Envio {

	private Cliente cliente;

	private Venta venta;

	private EstadoEnvio estado;

	private DateTime fechaEnvio;

	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Venta getVenta() {
		return venta;
	}

	private void setVenta(Venta venta) {
		this.venta = venta;
	}

	public EstadoEnvio getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}

	public DateTime getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(DateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	/**
	 * Constructor de la clase Envio
	 * @param cliente
	 * @param venta
	 * @param fecha
	 */
	
	public Envio(Cliente cliente, Venta venta, DateTime fecha) {

		this.setCliente(cliente);
		this.setVenta(venta);
		this.setFechaEnvio(fecha);
		this.setEstado(new PendienteDeEnvio());

	}
	/**
	 * Este metodo se utiliza para enviar el envio con un monto
	 */
	
	public void enviar(double cantAAbonar) throws EnProcesoException, SaldoInsuficienteCtaCteException{
		
		this.getEstado().enviar(this, cantAAbonar);
	}
	/**
	 * Cancela el envio, puede lanzar una exception
	 * @throws CanceladoException
	 */
	public void cancelar() throws CanceladoException {

		this.getEstado().cancelar(this);
	}
	/**
	 * Reprograma el Envio puede 
	 * @param fecha
	 * @throws ReprogramadoException
	 */
	public void reprogramar(DateTime fecha) throws ReprogramadoException {
		this.getEstado().reprogramar(this, fecha);
	}

	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		if (getClass() == other.getClass())
			return true;
		return false;
	}

}
