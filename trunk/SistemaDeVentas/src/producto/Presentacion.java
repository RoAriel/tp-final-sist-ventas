package producto;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.joda.time.DateTime;

import unidadDeMedida.UnidadDeMedida;

public class Presentacion extends Observable implements Observer {
	private int codigoDeBarras;
	private int precioDeVentaActual;
	private int precioDeCompraActual;
	private Map<DateTime, Integer> preciosDeVenta;
	private Map<DateTime, Integer> preciosDeCompra;
	private Stock stock;
	private UnidadDeMedida unidadDeMedida;
	private Ubicacion ubicacion;

	public Presentacion(int codigoDeBarras, UnidadDeMedida unidadDeMedida,
			int stockActual, int stockCritico, int stockMinimo,
			int precioDeVenta, int precioDeCompra, Ubicacion u) {
		this.codigoDeBarras = codigoDeBarras;
		this.precioDeCompraActual = precioDeCompra;
		this.precioDeVentaActual = precioDeVenta;

		// Se inicializa el historial de precios.
		this.preciosDeVenta = new HashMap<DateTime, Integer>();
		this.preciosDeVenta.put(new DateTime(), this.precioDeVentaActual);
		this.preciosDeCompra = new HashMap<DateTime, Integer>();
		this.preciosDeCompra.put(new DateTime(), precioDeCompra);

		this.stock = new Stock(stockActual, stockCritico, stockMinimo);
		this.unidadDeMedida = unidadDeMedida;
		this.ubicacion = u;
	}

	private int getCodigoDeBarras() {
		return codigoDeBarras;
	}

	private void setCodigoDeBarras(int codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	private int getPrecioDeVentaActual() {
		return precioDeVentaActual;
	}

	private void setPrecioDeVentaActual(int precioDeVentaActual) {
		this.precioDeVentaActual = precioDeVentaActual;
	}

	private int getPrecioDeCompraActual() {
		return precioDeCompraActual;
	}

	private void setPrecioDeCompraActual(int precioDeCompraActual) {
		this.precioDeCompraActual = precioDeCompraActual;
	}

	private Map<DateTime, Integer> getPreciosDeVenta() {
		return preciosDeVenta;
	}

	private void setPreciosDeVenta(Map<DateTime, Integer> preciosDeVenta) {
		this.preciosDeVenta = preciosDeVenta;
	}

	private Map<DateTime, Integer> getPreciosDeCompra() {
		return preciosDeCompra;
	}

	private void setPreciosDeCompra(Map<DateTime, Integer> preciosDeCompra) {
		this.preciosDeCompra = preciosDeCompra;
	}

	private Stock getStock() {
		return stock;
	}

	private void setStock(Stock stock) {
		this.stock = stock;
	}

	private UnidadDeMedida getUnidadDeMedida() {
		return unidadDeMedida;
	}

	private void setUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}

	private Ubicacion getUbicacion() {
		return ubicacion;
	}

	private void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * Proposito: Denota el codigo de barras.
	 * 
	 * @return
	 */
	public int codigoDeBarras() {
		return this.getCodigoDeBarras();
	}

	/**
	 * Proposito: Denota la cantidad de stock actual.
	 * 
	 * @return
	 */
	public int stock() {
		return this.getStock().stock();
	}

	/**
	 * Proposito: Denota el stock critico de la presentacion.
	 * 
	 * @return
	 */
	public int stockCritico() {
		return this.getStock().critico();
	}

	/**
	 * Proposito: Denota el stock minimo de la presentacion.
	 * 
	 * @return
	 */
	public int stockMinimo() {
		return this.getStock().minimo();
	}

	/**
	 * Proposito: Denota la unidad de medida.
	 * 
	 * @return
	 */
	public UnidadDeMedida unidadDeMedida() {
		return this.getUnidadDeMedida();
	}

	/**
	 * Proposito: Denota el precio actual de venta.
	 * 
	 * @return
	 */
	public int precioDeVenta() {
		return this.getPrecioDeVentaActual();
	}

	/**
	 * Proposito: Denota el precio actual de compra.
	 * 
	 * @return
	 */
	public int precioDeCompra() {
		return this.getPrecioDeCompraActual();
	}

	/**
	 * Proposito: Denota la ubicacion de la presentacion.
	 * 
	 * @return
	 */
	public Ubicacion ubicacion() {
		return this.getUbicacion();
	}

	/**
	 * Proposito: Cambio la ubicacion de la presentacion.
	 * 
	 * @param nuevaUbicacion
	 *            nueva ubicacion de la presentacion
	 */
	public void cambiarUbicacion(Ubicacion nuevaUbicacion) {
		this.setUbicacion(nuevaUbicacion);
	}

	/**
	 * Proposito: Denota el historial de precios por los cuales fue pasando el
	 * producto
	 * 
	 * @return Map<DateTime,Integer> <Fecha,Precio>
	 */
	public Map<DateTime, Integer> historialDePrecios() {
		return this.getPreciosDeVenta();
	}

	/**
	 * Proposito: Decrementa el stock del producto.
	 * 
	 * @param cantidadADecrementar
	 *            es la cantidad que se tiene que decrementar del producto
	 */
	public void decrementarStock(int cantidadADecrementar) {
		this.getStock().decrementarStock(cantidadADecrementar);
	}

	/**
	 * Porposito: Cambia el precio de venta de la presentacion.
	 * 
	 * @param nuevoPrecio
	 */
	public void nuevoPrecioVenta(int nuevoPrecio) {
		this.setPrecioDeVentaActual(nuevoPrecio);
		this.getPreciosDeVenta().put(new DateTime(), nuevoPrecio);
	}

	/**
	 * Proposito: Cambia el precio de compra de la presentacion
	 * 
	 * @param nuevoPrecio
	 */
	public void nuevoPrecioCompra(int nuevoPrecio) {
		this.setPrecioDeCompraActual(nuevoPrecio);
		this.getPreciosDeCompra().put(new DateTime(), nuevoPrecio);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		// se espera que en arg reciba la cantidad de unidades con las que
		// cuenta ahora la presentacion
		this.notifyObservers(arg);
	}
}
