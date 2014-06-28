package producto;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import cliente.Cliente;

public class Pedido implements Observer {
	private Cliente cliente;
	private Map<Presentacion, Integer> presentaciones;

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.presentaciones = new HashMap<Presentacion, Integer>();
	}

	private Cliente getCliente() {
		return cliente;
	}

	public Map<Presentacion, Integer> getPresentaciones() {
		return presentaciones;
	}

	/**
	 * Agrega una presentacion con la respectica contidad que se
	 * desea.
	 * 
	 * @param nuevaPresentacion
	 * @param cantidadPretendida
	 */
	public void agregarPresentacion(Presentacion nuevaPresentacion,
			Integer cantidadPretendida) {
		this.getPresentaciones().put(nuevaPresentacion, cantidadPretendida);
	}

	/**
	 * Quita una presentacion de las deseadas.
	 * 
	 * @param presentacionAQuitar
	 */
	public void quitarPresentacion(Presentacion presentacionAQuitar) {
		this.getPresentaciones().remove(presentacionAQuitar);
	}

	/**
	 * Notificar al cliente sobre su pedido completo.
	 */
	private void notificarCliente(){
		this.getCliente().notificacion("Su pedido se encuentra en stock.");
	}

	/**
	 * Denota true si se satisface el sotck para una precentacion en
	 * particular.
	 * 
	 * @param p
	 * @return
	 */
	private boolean satisfacePresentacion(Presentacion p) {
		return this.getPresentaciones().get(p) <= p.stock();
	}

	/**
	 * Denota true si se satisface el stock para todas las
	 * presentaciones.
	 * 
	 * @return
	 */
	private boolean satisfaceStock() {
		boolean ret = true;
		Set<Presentacion> presentaciones = this.getPresentaciones().keySet();
		for (Presentacion current : presentaciones) {
			// Chequea que la cantidad desea de la presentacion, esta satisfecha
			// por el stock actual.
			ret = ret && this.satisfacePresentacion(current);
		}
		return ret;
	}

	/**
	 * Chequea si se cumplen las condiciones del pedido, tomando las
	 * acciones correspondientes
	 */
	private void chequearPedido() {
		if (this.satisfaceStock()) {
			this.notificarCliente();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (this.getPresentaciones().containsKey((Presentacion) arg0)) {
			this.chequearPedido();
		}
	}

}
