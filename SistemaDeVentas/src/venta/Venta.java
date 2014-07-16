package venta;

import java.util.List;

import org.joda.time.DateTime;

import producto.Presentacion;
import venta.VentaADomicilio;
import cliente.Cliente;
import exceptions.SaldoInsuficienteCtaCteException;
import exceptions.StockInsuficienteException;
import formaDePago.FormaDePago;

public class Venta {

	private List<Presentacion> productos;
	private List<Presentacion> productosSinStock;
	private Cliente cliente;
	private FormaDePago formaDePago;

	private DateTime fechaDeSolicitudDeCompra;// es la fecha en la que el cliente 
	  //solicita la compra


	public DateTime getFechaDeSolicitudDeCompra() {
		return fechaDeSolicitudDeCompra;
	}
	
	public Boolean esVentaADomicilio(){
		return false;
	}
	
	public Boolean esVentaPendienteDeEntrega(){
		if (this.esVentaADomicilio()){
			VentaADomicilio v2 = (VentaADomicilio) this;
			return v2.getEnvio().getEstado().esPendienteDeEnvio();
		}
		return false;
	}

	public void setFechaDeSolicitudDeCompra(DateTime dechaDeSolicitudDeCompra) {
		this.fechaDeSolicitudDeCompra = dechaDeSolicitudDeCompra;
	}
	
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

	/**
	 * Se agregan Presentaciones a la venta 
	 * @param pre
	 * @param cant
	 * @throws StockInsuficienteException
	 */
	public void agregarProducto(Presentacion pre, int cant)	throws StockInsuficienteException {

		pre.decrementarStock(cant);
		
		for (int i = 0; i < cant; i++) {
			this.getProductos().add(pre);

		}

	}
	/**
	 * Sequietan los productos especificados de la lista
	 * 
	 * @param pre
	 * @param cant
	 */
	public void sacarProducto(Presentacion pre, int cant) {

		for (int i = 0; i < cant; i++) {

			this.getProductos().remove(pre);
		}

	}
	
	/**
	 * 
	 * Pido el total de la  venta
	 * @return
	 */
	
	public double subTotal(){
		
		Double total = (double) 0;
		
		List<Presentacion>pres = this.getProductos();
		List<Presentacion>presSinStock = this.getProductosSinStock();
		
		for (Presentacion presentacion : pres) {
			
			total+= presentacion.getPrecioDeVentaActual();
		}
		
		for (Presentacion presentacion : presSinStock) {
			
			total+= presentacion.getPrecioDeVentaActual();
		}
		
		return total;
	}
	
	/**
	 * Se devuelve la compra vaciando las listas
	 */
	public void devolverCompra(){
		
		for(Presentacion p : this.getProductos()){
			
			p.aumentarStock(1);
			
		}
		
		this.getProductos().clear();
		
	}
	
	/**
	 * 
	 * Se le cobra al cliente puede lanzar exception
	 * @throws SaldoInsuficienteCtaCteException
	 */
	
	public void cobrar() throws SaldoInsuficienteCtaCteException{
			
		double monto = this.subTotal();
		this.getFormaDePago().cobrar(this.getCliente(), monto);
	}
}
