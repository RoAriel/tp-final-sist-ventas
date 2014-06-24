package venta;

import java.util.List;

import producto.Presentacion;

public class Venta {

	private List<Presentacion> productos;
	private List<Presentacion> productosSinStock;
	private Cliente cliente;
	private FormaDePago formaDePago;

	public List<Presentacion> getProductos() {
		return productos;
	}

	public List<Presentacion> getProductosSinStock() {
		return productosSinStock;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public FormaDePago getFormaDePago() {
		return formaDePago;
	}

	private void setProductos(List<Presentacion> productos) {
		this.productos = productos;
	}

	private void setProductosSinStock(List<Presentacion> productosSinStock) {
		this.productosSinStock = productosSinStock;
	}

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

}
