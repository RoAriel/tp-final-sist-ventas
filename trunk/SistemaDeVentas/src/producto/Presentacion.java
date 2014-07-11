package producto;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.joda.time.DateTime;

import exceptions.StockInsuficienteException;
import unidadDeMedida.UnidadDeMedida;

public class Presentacion extends Observable implements Observer {
	private String codigoDeBarras;
	private double precioDeVentaActual;
	private double precioDeCompraActual;
	private Map<DateTime, Double> preciosDeVenta;
	private Map<DateTime, Double> preciosDeCompra;
	private Stock stock;
	private UnidadDeMedida unidadDeMedida;
	private Ubicacion ubicacion;

	public Presentacion(String codigoDeBarras, UnidadDeMedida unidadDeMedida,
			int stockActual, int stockMinimo, int stockCritico,
			double precioDeVenta, double precioDeCompra, Ubicacion u) {
		this.codigoDeBarras = codigoDeBarras;
		this.precioDeCompraActual = precioDeCompra;
		this.precioDeVentaActual = precioDeVenta;

		inicializarHistorialPrecios();

		this.stock = new Stock(stockActual, stockMinimo, stockCritico);
		this.unidadDeMedida = unidadDeMedida;
		this.setUbicacion(u);
	}

	private void inicializarHistorialPrecios() {
		// Se inicializa el historial de precios.
		this.preciosDeVenta = new HashMap<DateTime, Double>();
		this.preciosDeVenta.put(new DateTime(), this.precioDeVentaActual);
		this.preciosDeCompra = new HashMap<DateTime, Double>();
		this.preciosDeCompra.put(new DateTime(), this.precioDeCompraActual);
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public double getPrecioDeVentaActual() {
		return precioDeVentaActual;
	}

	private void setPrecioDeVentaActual(double precioDeVentaActual) {
		this.precioDeVentaActual = precioDeVentaActual;
	}

	private double getPrecioDeCompraActual() {
		return precioDeCompraActual;
	}

	private void setPrecioDeCompraActual(double precioDeCompraActual) {
		this.precioDeCompraActual = precioDeCompraActual;
	}

	private Map<DateTime, Double> getPreciosDeVenta() {
		return preciosDeVenta;
	}

	private Map<DateTime, Double> getPreciosDeCompra() {
		return preciosDeCompra;
	}

	private Stock getStock() {
		return stock;
	}

	/**
	 * Devuelve la unidad de medida de la presentacion.
	 * 
	 * @return UnidadDeMedida
	 */
	private UnidadDeMedida getUnidadDeMedida() {
		return unidadDeMedida;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * Denota el codigo de barras.
	 * 
	 * @return
	 */
	public String codigoDeBarras() {
		return this.getCodigoDeBarras();
	}

	/**
	 * Denota la cantidad de stock actual.
	 * 
	 * @return
	 */
	public int stock() {
		return this.getStock().stock();
	}

	/**
	 * Denota el stock critico de la presentacion.
	 * 
	 * @return
	 */
	public int stockCritico() {
		return this.getStock().critico();
	}

	/**
	 * Denota el stock minimo de la presentacion.
	 * 
	 * @return
	 */
	public int stockMinimo() {
		return this.getStock().minimo();
	}

	/**
	 * Denota la unidad de medida.
	 * 
	 * @return
	 */
	public UnidadDeMedida unidadDeMedida() {
		return this.getUnidadDeMedida();
	}

	/**
	 * Denota el precio actual de venta.
	 * 
	 * @return
	 */
	public Double precioDeVenta() {
		return this.getPrecioDeVentaActual();
	}

	/**
	 * Denota el precio actual de compra.
	 * 
	 * @return
	 */
	public Double precioDeCompra() {
		return this.getPrecioDeCompraActual();
	}

	/**
	 * Denota la ubicacion de la presentacion.
	 * 
	 * @return
	 */
	public Ubicacion ubicacion() {
		return this.ubicacion;
	}

	/**
	 * Cambio la ubicacion de la presentacion.
	 * 
	 * @param nuevaUbicacion
	 *            nueva ubicacion de la presentacion
	 */
	public void cambiarUbicacion(Ubicacion nuevaUbicacion) {
		this.setUbicacion(nuevaUbicacion);
	}

	/**
	 * Denota el historial de precios por los cuales fue pasando el producto
	 * 
	 * @return Map<DateTime,Integer> <Fecha,Precio>
	 */
	public Map<DateTime, Double> historialDePrecios() {
		return this.getPreciosDeVenta();
	}

	/**
	 * Denota el historial de precios de compra por los cuales fue pasando el
	 * producto.
	 * 
	 * @return Map<DateTime,Integer> <Fecha,Precio>
	 */
	public Map<DateTime, Double> historialDePreciosCompra() {
		return this.preciosDeCompra;
	}

	/**
	 * Aumenta el stock de la presentacion.
	 * 
	 * @param cantidadAAumentar
	 */
	public void aumentarStock(int cantidadAAumentar) {
		this.getStock().agregarStock(cantidadAAumentar);
	}

	/**
	 * Decrementa el stock de la presentacion.
	 * 
	 * @param cantidadADecrementar
	 *            es la cantidad que se tiene que decrementar del producto
	 */
	public void decrementarStock(int cantidadADecrementar)
			throws StockInsuficienteException {
		this.getStock().decrementarStock(cantidadADecrementar);
	}

	/**
	 * Cambia el precio de venta de la presentacion.
	 * 
	 * @param nuevoPrecio
	 */
	public void nuevoPrecioVenta(Double nuevoPrecio) {
		this.setPrecioDeVentaActual(nuevoPrecio);
		this.getPreciosDeVenta().put(this.dateTimeToday(), nuevoPrecio);
	}

	/**
	 * Cambia el precio de compra de la presentacion
	 * 
	 * @param nuevoPrecio
	 */
	public void nuevoPrecioCompra(Double nuevoPrecio) {
		this.setPrecioDeCompraActual(nuevoPrecio);
		this.getPreciosDeCompra().put(this.dateTimeToday(), nuevoPrecio);
	}

	private DateTime dateTimeToday() {
		DateTime t = new DateTime();
		DateTime ret = new DateTime(t.getYear(), t.getMonthOfYear(),
				t.getDayOfMonth(), 0, 0, 0);
		return ret;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		// se espera que en arg reciba la cantidad de unidades con las que
		// cuenta ahora la presentacion
		this.notifyObservers(arg);
	}
}
