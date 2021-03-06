package envio;

import org.joda.time.DateTime;

import exceptions.CanceladoException;
import exceptions.EnProcesoException;
import exceptions.ReprogramadoException;
import exceptions.SaldoInsuficienteCtaCteException;

public abstract class EstadoEnvio {

	public void enviar(Envio env, double cantAAbonar)  throws EnProcesoException, SaldoInsuficienteCtaCteException{
		
		env.setEstado(new EnProceso());
		env.enviar(cantAAbonar); 
	}
	
	public Boolean esPendienteDeEnvio(){
		return false;
	}
	
	
	public void cancelar(Envio env) throws CanceladoException{
		
		env.getVenta().devolverCompra();
		env.setEstado(new Cancelado());
		
	}
	
	public void reprogramar(Envio env, DateTime fecha) throws ReprogramadoException{
		
		env.getVenta().devolverCompra();
		env.setEstado(new Reprogramado());
		env.reprogramar(fecha);
	}
	
}
