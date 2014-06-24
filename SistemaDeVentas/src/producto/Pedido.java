package producto;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import cliente.Cliente;

public class Pedido implements Observer {
	private Cliente cliente;
	private Map<Presentacion, Integer> presentaciones;

	public void pedido(Cliente cliente) {
		this.cliente = cliente;
		this.presentaciones = new HashMap<Presentacion, Integer>();
	}

	private Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	private Map<Presentacion, Integer> getPresentaciones() {
		return presentaciones;
	}

	private void setPresentaciones(Map<Presentacion, Integer> presentaciones) {
		this.presentaciones = presentaciones;
	}

	/**
	 * Proposito: Agrega una presentacion con la respectica contidad que se
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
	 * Proposito: Quita una presentacion de las deseadas.
	 * 
	 * @param presentacionAQuitar
	 */
	public void quitarPresentacion(Presentacion presentacionAQuitar) {
		this.getPresentaciones().remove(presentacionAQuitar);
	}

	/**
	 * Proposito: Notificar al cliente sobre su pedido completo.
	 */
	private void notificarCliente(){
		String listaProductos = this.getPresentaciones().toString();
		this.getCliente().notificacion("Su pedido de: "+listaProductos+" se encuentra en stock.");
	}

	/**
	 * Proposito: Denota true si se satisface el sotck para una precentacion en
	 * particular.
	 * 
	 * @param p
	 * @return
	 */
	private boolean satisfacePresentacion(Presentacion p) {
		return this.getPresentaciones().get(p) <= p.stock();
	}

	/**
	 * Proposito: Denota true si se satisface el stock para todas las
	 * presentaciones.
	 * 
	 * @return
	 */
	private boolean satisfaceStock() {
		boolean ret = true;
		for (Presentacion current : this.getPresentaciones().keySet()) {
			// Chequea que la cantidad desea de la presentacion, esta satisfecha
			// por el stock actual.
			ret = ret && this.satisfacePresentacion(current);
		}
		return ret;
	}

	/**
	 * Proposito: Chequea si se cumplen las condiciones del pedido, tomando las
	 * acciones correspondientes
	 */
	private void chequearPedido() {
		if (this.satisfaceStock()) {
			this.notificarCliente();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if (this.getPresentaciones().containsKey((Presentacion) arg1)) {
			this.chequearPedido();
		}
	}

}
