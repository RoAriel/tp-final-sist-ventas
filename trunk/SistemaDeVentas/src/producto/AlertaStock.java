package producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AlertaStock extends Observable implements Observer {
	// este atributo interno es para mostrar la lista de pedidos que tiene la
	// alerta.
	private List<Pedido> pedidos;

	public AlertaStock() {
		this.pedidos = new ArrayList<Pedido>();
	}

	private List<Pedido> getPedidos() {
		return pedidos;
	}

	private void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	/**
	 * Proposito: Se agrega un nuevo pedido sobre los cuales se quiere
	 * notificar.
	 * 
	 * @param nuevoPedido
	 *            nuevo pedido a agregar.
	 */
	public void agregarPedido(Pedido nuevoPedido) {
		this.addObserver(nuevoPedido);
		this.getPedidos().add(nuevoPedido);
	}

	/**
	 * Proposito: Quita un pedido a los cuales se les notifica el cambio de
	 * stock.
	 * 
	 * @param pedidoAQuitar
	 */
	public void quitarPedido(Pedido pedidoAQuitar) {
		this.deleteObserver(pedidoAQuitar);
		this.getPedidos().remove(pedidoAQuitar);
	}

	public List<Pedido> pedidos() {
		return this.getPedidos();
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setChanged();
		// A los observers se les pasa como arg la presentacion que cambio
		this.notifyObservers((Presentacion) o);
	}

}
