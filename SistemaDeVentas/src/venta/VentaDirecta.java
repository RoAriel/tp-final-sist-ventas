package venta;

import java.util.ArrayList;
import java.util.List;

import producto.Presentacion;
import exceptions.StockInsuficienteException;
import formaDePago.PagoConCuentaCorriente;
import formaDePago.PagoEnEfectivo;

public class VentaDirecta extends Venta {

	public VentaDirecta(){

		this.setProductos(new ArrayList<Presentacion>());
		this.setProductosSinStock(new ArrayList<Presentacion>());
		this.setFormaDePago(new PagoEnEfectivo());

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

}
