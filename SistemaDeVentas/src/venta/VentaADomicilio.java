package venta;

import org.joda.time.DateTime;

import producto.Presentacion;
import cliente.Cliente;
import exceptions.StockInsuficienteException;

public class VentaADomicilio extends Venta {

	private Envio envio;

	public Envio getEnvio() {
		return envio;
	}

	private void setEnvio(Envio envio) {
		this.envio = envio;
	}

	public VentaADomicilio(DateTime fechaEnvio, Cliente cliente) {

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

	public void postergarEntrega(DateTime fechaEnvio) {

		this.getEnvio().reprogramar(fechaEnvio);
	}

}
