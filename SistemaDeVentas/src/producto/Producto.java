package producto;

import java.util.ArrayList;
import java.util.List;

public class Producto {

	private String nombre;
	private String marca;
	private String descripcion;
	private List<Presentacion> presentaciones;

	public Producto(String nombre, String marca, String descripcion) {
		this.nombre = nombre;
		this.marca = marca;
		this.descripcion = descripcion;
		this.presentaciones = new ArrayList<Presentacion>();
	}

	/**
	 * Denota el nombre del producto.
	 * 
	 * @return
	 */
	public String nombre() {
		return this.nombre;
	}

	/**
	 * Denota la marca del producto.
	 * 
	 * @return
	 */
	public String marca() {
		return this.marca;
	}

	/**
	 * Denota la descripcion del producto.
	 * 
	 * @return
	 */
	public String descripcion() {
		return this.descripcion;
	}

	/**
	 * Denota la lista de presentaciones.
	 * 
	 * @return
	 */
	public List<Presentacion> presentaciones() {
		return this.presentaciones;
	}
	
	/**
	 * Se agrega una nueva presentacion correspondiente al producto
	 * @param nuevaPresentacion presentacion a agregar al prodcuto
	 */
	public void agregarPresentacion(Presentacion nuevaPresentacion){
		this.presentaciones().add(nuevaPresentacion);
	}
	
	/**
	 * Se quita una presentacion al producto
	 * @param presentacionQuitar presentacion a quitar.
	 */
	public void quitarPresentacion(Presentacion presentacionQuitar){
		this.presentaciones().remove(presentacionQuitar);
	}
}
