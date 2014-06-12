package venta;

public abstract class EstadoEnvio {

	public abstract void enviar(Envio env);
	
	public abstract void cancelar(Envio env);
	
	public abstract void reporgramar(Envio env);
	
}
