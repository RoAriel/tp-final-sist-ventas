package venta;

import org.joda.time.DateTime;

public class Envio {

	private Cliente cliente;
	
	private Venta venta;
	
	private EstadoEnvio estado;
	
	private DateTime fechaEnvio;
	
	
	
	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Venta getVenta() {
		return venta;
	}



	public void setVenta(Venta venta) {
		this.venta = venta;
	}



	public EstadoEnvio getEstado() {
		return estado;
	}



	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}



	public DateTime getFechaEnvio() {
		return fechaEnvio;
	}



	public void setFechaEnvio(DateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}



	public Envio(Cliente cliente, Venta venta, DateTime fecha){
		
		this.setCliente(cliente);
		this.setVenta(venta);
		this.setFechaEnvio(fecha);
		this.setEstado(new PendienteDeEnvio());
		
	}
	
	public void enviar(float cantidadAAbonar){
		
	}
	
	public void cancelar(){
		
		this.getEstado().cancelar(this);
	}
	
	public void reprogramar(DateTime fecha){
		this.getEstado().reprogramar(this, fecha);
	}
	
	private void devolverProductosAlStock(){
		
		
	}
	
	

}
