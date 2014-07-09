package venta;

import java.util.List;

import producto.Presentacion;
import cliente.Cliente;
import exceptions.SaldoInsuficienteCtaCteException;
import exceptions.StockInsuficienteException;
import formaDePago.FormaDePago;

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

	protected void setProductos(List<Presentacion> productos) {
		this.productos = productos;
	}

	protected void setProductosSinStock(List<Presentacion> productosSinStock) {
		this.productosSinStock = productosSinStock;
	}

	protected void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	protected void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}

	public void agregarProducto(Presentacion pre, int cant)	throws StockInsuficienteException {

		pre.decrementarStock(cant);
		
		for (int i = 0; i < cant; i++) {
			this.getProductos().add(pre);

		}

	}
	
	public void sacarProducto(Presentacion pre, int cant) {

		for (int i = 0; i < cant; i++) {

			this.getProductos().remove(pre);
		}

	}
	
	public double subTotal(){
		
		Double total = (double) 0;
		
		List<Presentacion>pres = this.getProductos();
		
		for (Presentacion presentacion : pres) {
			
			total+= presentacion.getPrecioDeVentaActual();
		}
		
		return total;
	}
	
	public void devolverCompra(){
		
		for(Presentacion p : this.getProductos()){
			
			p.aumentarStock(1);
			
		}
		
		this.getProductos().clear();
		
	}
	
	public void cobrar() throws SaldoInsuficienteCtaCteException{
		
		
		double monto = this.subTotal();
		this.getFormaDePago().cobrar(this.getCliente(), monto);
	}
}
