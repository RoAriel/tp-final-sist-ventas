package venta;

import java.util.ArrayList;

import producto.Presentacion;
import cliente.Cliente;
import formaDePago.PagoEnEfectivo;

public class VentaDirecta extends Venta {

	public VentaDirecta(){

		this.setProductos(new ArrayList<Presentacion>());
		this.setProductosSinStock(new ArrayList<Presentacion>());
		this.setFormaDePago(new PagoEnEfectivo());

	}

	public VentaDirecta(Cliente cliente){

		/// Preguntar!!!!!!!!
		this.setCliente(new Cliente());
		this.setProductos(new ArrayList<Presentacion>());
		this.setProductosSinStock(new ArrayList<Presentacion>());
		this.setFormaDePago(new PagoEnEfectivo());
	}

}
