package venta;

import java.util.ArrayList;

import org.joda.time.DateTime;

import producto.Presentacion;
import cliente.Cliente;
import envio.Envio;
import envio.PendienteDeEnvio;
import exceptions.ReprogramadoException;
import exceptions.StockInsuficienteException;
import formaDePago.FormaDePago;

public class VentaADomicilio extends Venta {

	private Envio envio;
	private DateTime fechaEntrega;

	public DateTime getFechaEntrega() {
		return fechaEntrega;
	}

	private void setFechaEntrega(DateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Envio getEnvio() {
		return envio;
	}

	private void setEnvio(Envio envio) {
		this.envio = envio;
	}

	public VentaADomicilio(DateTime fechaEnvio, Cliente cliente, FormaDePago fp) {

		Envio env = new Envio(cliente, this, fechaEnvio);
		env.setEstado(new PendienteDeEnvio());

		this.setProductos(new ArrayList<Presentacion>());
		this.setProductosSinStock(new ArrayList<Presentacion>());
		this.setCliente(cliente);
		this.setFechaEntrega(fechaEnvio);
		this.setEnvio(env);
		this.setFormaDePago(fp);

	}

	public void agregarProductoSinStock(Presentacion pre, int cant) {

		for (int i = 0; i < cant; i++) {
			this.getProductosSinStock().add(pre);

		}

	}

	public void agregarProducto(Presentacion pre, int cant) {

		try {

			pre.decrementarStock(cant);
			this.getProductos().add(pre);

		} catch (StockInsuficienteException e) {

			this.agregarProductoSinStock(pre, cant);

		}
	}

	public void postergarEntrega(DateTime fechaEnvio) throws ReprogramadoException {

		this.getEnvio().reprogramar(fechaEnvio);
	}

	public void sacarProductosDelLosPedidosSinStock(Presentacion pre, int cant) {

		for (int i = 0; i < cant; i++) {

			this.getProductosSinStock().remove(pre);

		}
	}

}
