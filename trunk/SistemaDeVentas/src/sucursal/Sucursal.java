package sucursal;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import producto.AlertaStock;
import producto.Presentacion;
import venta.Venta;
import cliente.Cliente;

public class Sucursal {
	
	Map<Cliente, List<Venta>> registroVenta;
	List<Presentacion> productos;
	AlertaStock alerta;
	
	public Sucursal (List<Presentacion> lp, Map<Cliente, List<Venta>> reg){
		registroVenta = reg;
		productos = lp;
		
	}
	
	public void registrarVenta(Cliente c , Venta nuevaVenta){
		getRegistroVenta().get(c).add(nuevaVenta);
	}
	
	public void registrarCliente (Cliente c){
		getRegistroVenta().put(c, new ArrayList<Venta>());
	}
	
	public List<Venta> ventasDesdeHastaMonto(float desde,float hasta, Cliente c){
		List<Venta> ret = new ArrayList<Venta>(this.getRegistroVenta().get(c));
		for(Venta v : ret){
			if (!(desde <= v.subTotal() && v.subTotal() <= hasta)){
				ret.remove(v);
			}
		}
		return ret;
	}
	
	public List<Venta> ventaDesdeHastaFecha(DateTime desde, DateTime hasta, Cliente c){
		List<Venta> ret = new ArrayList<Venta>(this.getRegistroVenta().get(c));
		for(Venta v : ret){
			//comparar por fecha de solicitud de compra{
				//descartar las ventas que no cumplen la condicion
		    //}
		}
		return ret;
	}
	
	public List<Presentacion> productosPorDebajoDeStockMinimo(){
		List<Presentacion> ret = this.getProductos() ;
		for(Presentacion p: ret){
			if (p.stock()>=p.stockMinimo()){
				ret.remove(p);
			}
		}
		return ret;
	}
	
	public List<Presentacion> productosPorDebajoDeStockCritico(){
		List<Presentacion> ret = this.getProductos() ;
		for(Presentacion p: ret){
			if (p.stock()>=p.stockCritico()){
				ret.remove(p);
			}
		}
		return ret;
	}

	public Map<Cliente, List<Venta>> getRegistroVenta() {
		return registroVenta;
	}

	public void setRegistroVenta(Map<Cliente, List<Venta>> registroVenta) {
		this.registroVenta = registroVenta;
	}

	public List<Presentacion> getProductos() {
		return productos;
	}

	public void setProductos(List<Presentacion> productos) {
		this.productos = productos;
	}

	public AlertaStock getAlerta() {
		return alerta;
	}

	public void setAlerta(AlertaStock alerta) {
		this.alerta = alerta;
	}

}

