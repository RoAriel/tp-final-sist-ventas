package venta;

import org.joda.time.DateTime;



public class VentaADomicilio extends Venta {
	
	private Envio envio;

	public Envio getEnvio() {
		return envio;
	}

	private void setEnvio(Envio envio) {
		this.envio = envio;
	}
	
	public VentaADomicilio(DateTime fechaEnvio, Cliente cliente){
		
	}
	
	public void postergarEntrega(DateTime fechaEnvio){
		
		this.getEnvio().reprogramar(fechaEnvio);
	}

}
