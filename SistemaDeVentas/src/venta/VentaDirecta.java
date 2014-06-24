package venta;

import java.util.HashMap;

import exceptionVenta.AccionInvalidaException;
import exceptionVenta.VentaDirectaStockInvalidoException;
import producto.Presentacion;

public class VentaDirecta extends Venta {
	
	private HashMap<Presentacion, Integer> miListaDeCompras;
	
	private void setMiListaDeCompras(HashMap lista){
		
		this.miListaDeCompras = new HashMap<Presentacion, Integer>();
	}
	
	public HashMap<Presentacion, Integer> getListaDeCompras(){
		
		return this.miListaDeCompras;
	}
	
	public VentaDirecta(){
	
		HashMap<Presentacion, Integer> miLista = new HashMap<Presentacion, Integer>();
		this.setMiListaDeCompras(miLista);
				
	}

	public VentaDirecta(Cliente cliente){
		
		HashMap<Presentacion, Integer> miLista = new HashMap<Presentacion, Integer>();
		this.setMiListaDeCompras(miLista);
		
	}
	
	
	/**
	 * Este metodo seutiliza para ir cargando la venta del cliente en caja
	 * 
	 * @param presentacion es el producto que se va a vender
	 * @param cantidad es la cantidad que el cliente va a llevar del producto
	 */
	
	public void agregarProducto(Presentacion presentacion, int cantidad){
		
		this.getListaDeCompras().put(presentacion, cantidad);
		presentacion.decrementarStock(cantidad);
		for (int i = 0; i < cantidad; i++) {
			
			this.getProductos().add(presentacion);
		
		}
		
	}
	
	public void agrgarProductoSinStock(Presentacion pre, int cantidad) throws VentaDirectaStockInvalidoException{
		
		throw new VentaDirectaStockInvalidoException
				("En Venta Directa n sepueen vernder productos sin Stock");
	}

	public void sacarProduco(Presentacion pres, int cant) throws AccionInvalidaException{
		
		for (int i = 0; i < cant; i++) {
			
			this.getProductos().remove(pres);
		}
		
		
	}

	public double subTotal(){
		
		double total = 0;
		for(Presentacion p : this.getProductos()){
			
			total += p.precioDeVenta();
			
		}
		
		return total;
	}

	public void cancelarVenta(){
		
		for(Presentacion p : this.getProductos()){
			
			p.aumentarStock(1);
		}
	}

	public HashMap<Presentacion, Integer> listaDeProduto(){
		
		return this.getListaDeCompras();
	}

	public void facturar(){

	}
}
