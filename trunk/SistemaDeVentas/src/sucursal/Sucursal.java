package sucursal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import producto.AlertaStock;
import producto.Presentacion;
import producto.Producto;
import venta.Venta;
import cliente.Cliente;

public class Sucursal {

	Map<Cliente, List<Venta>> registroVenta;
	List<Producto> productos;
	AlertaStock alerta;

	public Sucursal(List<Producto> lp, Map<Cliente, List<Venta>> reg) {
		registroVenta = reg;
		productos = lp;
		alerta = new AlertaStock();

	}

	public void registrarVenta(Cliente c, Venta nuevaVenta) {

		if (!this.getRegistroVenta().containsKey(c)) {
			this.registrarCliente(c);
		}
		this.getRegistroVenta().get(c).add(nuevaVenta);
	}

	public void registrarCliente(Cliente c) {
		getRegistroVenta().put(c, new ArrayList<Venta>());
	}

	public void agregarPresentacion(Producto producto, Presentacion presentacion) {
		producto.agregarPresentacion(presentacion);
	}

	public List<Venta> ventasDesdeHastaMonto(Double desde, Double hasta,
			Cliente c) {
		List<Venta> ventas = this.getRegistroVenta().get(c);
		List<Venta> ret = new ArrayList<Venta>();
		for (Venta v : ventas) {
			if ((desde <= v.subTotal()) && (v.subTotal() <= hasta)) {
				// if (!(desde < v.subTotal() && v.subTotal() < hasta)){
				ret.add(v);
			}
		}
		return ret;
	}

	public List<Venta> ventaDesdeHastaFecha(DateTime desde, DateTime hasta,
			Cliente c) {
		List<Venta> ventas = this.getRegistroVenta().get(c);
		List<Venta> ret = new ArrayList<Venta>();
		for (Venta v : ventas) {
			if (v.getFechaDeSolicitudDeCompra().isBefore(hasta)
					&& v.getFechaDeSolicitudDeCompra().isAfter(desde)) {
				ret.add(v);
			}
		}
		return ret;
	}

	public List<Presentacion> productosPorDebajoDeStockMinimo() {
		List<Presentacion> ret = new ArrayList<Presentacion>();
		List<Producto> productos = this.getProductos();

		for (Producto current : productos) {
			List<Presentacion> listaPresentaciones = current.presentaciones();
			for (Presentacion presentacion : listaPresentaciones) {
				if (presentacion.stock() <= presentacion.stockMinimo()) {
					ret.add(presentacion);
				}
			}
		}

		return ret;
}

	public List<Presentacion> productosPorDebajoDeStockCritico() {
		List<Presentacion> ret = new ArrayList<Presentacion>();
		List<Producto> productos = this.getProductos();

		for (Producto current : productos) {
			List<Presentacion> listaPresentaciones = current.presentaciones();
			for (Presentacion presentacion : listaPresentaciones) {
				if (presentacion.stock() >= presentacion.stockCritico()) {
					ret.add(presentacion);
				}
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public AlertaStock getAlerta() {
		return alerta;
	}

	public void setAlerta(AlertaStock alerta) {
		this.alerta = alerta;
	}

}
