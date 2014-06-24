package cliente;

import java.util.Observable;
import java.util.Observer;

import producto.Presentacion;

public class Cliente implements Observer{
	private String nombre;
	private String apellido;
	private Integer dni;
	private CuentaCorriente ctaCte;
	private Direccion direccion;
	
	public Cliente(String nombre, String apellido,Integer dni,Direccion direccion){
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.ctaCte = new CuentaCorriente(this);
		this.direccion = direccion;
	}

	private String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String getApellido() {
		return apellido;
	}

	private void setApellido(String apellido) {
		this.apellido = apellido;
	}

	private Integer getDni() {
		return dni;
	}

	private void setDni(Integer dni) {
		this.dni = dni;
	}

	private CuentaCorriente getCtaCte() {
		return ctaCte;
	}

	private void setCtaCte(CuentaCorriente ctaCte) {
		this.ctaCte = ctaCte;
	}

	private Direccion getDireccion() {
		return direccion;
	}

	private void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Proposito: Cambia la direccion del cliente por nuevaDireccion
	 * @param nuevaDireccion nueva direccion del cliente
	 */
	public void cambiarDireccion(Direccion nuevaDireccion){
		this.setDireccion(nuevaDireccion);
	}
	
	public void devolverProducto(Presentacion presentacionDevuelta){
		presentacionDevuelta.aumentarStock(1);
		this.getCtaCte().depositar(presentacionDevuelta.precioDeVenta());
		//COMPLETAR
	}
	
	/**
	 * Proposito: El cliente recibe una notificacion.
	 * @param notificacion
	 */
	public void notificacion(String notificacion){
		System.out.println(notificacion);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.notificacion((String)arg1);		
	}
	
	
}
