package cliente;

import java.util.Observable;
import java.util.Observer;

import producto.Presentacion;

public class Cliente implements Observer{
	private String nombre;
	private String apellido;
	private String dni;
	private CuentaCorriente ctaCte;
	private Direccion direccion;
	
	public Cliente(String nombre, String apellido,String dni,Direccion direccion){
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.ctaCte = new CuentaCorriente(this);
		this.direccion = direccion;
	}

	public CuentaCorriente getCtaCte() {
		return ctaCte;
	}

	private void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public String nombre(){
		return nombre;
	}
	
	public String apellido(){
		return apellido;
	}
	
	public Direccion direccion(){
		return direccion;
	}
	
	public String dni(){
		return dni;
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
	
	/**
	 * Se usa en los test par preguntar si lo esperado es del tipo Cliente
	 */
	public boolean equals(Object other) {
		 if (other == this) return true;
		   if (other == null) return false;
		   if (getClass() == other.getClass()) return true;
		return false;
	}
	

}
