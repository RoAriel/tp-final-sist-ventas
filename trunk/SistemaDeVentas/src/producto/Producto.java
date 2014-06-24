package producto;

import java.util.ArrayList;
import java.util.List;

public class Producto {

	private String nombre;
	private String marca;
	private String descripcion;
	private List<Presentacion> presentaciones;
	private Ubicacion ubicacion;

	public Producto(String nombre, String marca, String descripcion,
			Ubicacion ubicacion) {
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.presentaciones = new ArrayList<Presentacion>();
		this.ubicacion = ubicacion;
	}

	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String getMarca() {
		return marca;
	}

	private void setMarca(String marca) {
		this.marca = marca;
	}

	private String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private List<Presentacion> getPresentaciones() {
		return presentaciones;
	}

	private void setPresentaciones(List<Presentacion> presentaciones) {
		this.presentaciones = presentaciones;
	}

	private Ubicacion getUbicacion() {
		return ubicacion;
	}

	private void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * Proposito: Denota el nombre del producto.
	 * 
	 * @return
	 */
	public String nombre() {
		return this.getNombre();
	}

	/**
	 * Proposito: Denota la marca del producto.
	 * 
	 * @return
	 */
	public String marca() {
		return this.getMarca();
	}

	/**
	 * Proposito: Denota la descripcion del producto.
	 * 
	 * @return
	 */
	public String descripcion() {
		return this.getDescripcion();
	}

	/**
	 * Proposito: Denota la lista de presentaciones.
	 * 
	 * @return
	 */
	public List<Presentacion> presentaciones() {
		return this.getPresentaciones();
	}

	public void decrementarStock(Presentacion p, int cantidad) {
		p.decrementarStock(cantidad);
	}
}
