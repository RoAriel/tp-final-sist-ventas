package venta;

import java.util.ArrayList;

import producto.Presentacion;
import cliente.Cliente;
import cliente.Direccion;
import formaDePago.FormaDePago;
import formaDePago.PagoEnEfectivo;

public class VentaDirecta extends Venta {

	public VentaDirecta(){

		this.setCliente(new Cliente("None","None","None",new Direccion("None", "None","None","None")));
		this.setProductos(new ArrayList<Presentacion>());
		this.setProductosSinStock(new ArrayList<Presentacion>());
		this.setFormaDePago(new PagoEnEfectivo());

	}

	public VentaDirecta(Cliente cliente , FormaDePago fp){

		/// Preguntar!!!!!!!! el new  para que pasen los test
		
		this.setCliente(cliente);
		this.setProductos(new ArrayList<Presentacion>());
		this.setProductosSinStock(new ArrayList<Presentacion>());
		this.setFormaDePago(fp);
	}

}
