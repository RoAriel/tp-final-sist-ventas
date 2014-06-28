package producto;

import java.util.Observable;

import exceptions.StockInsuficienteException;

public class Stock extends Observable {
	int stockActual;
	int stockCritico;
	int stockMinimo;

	protected Stock(int stock, int minimo, int critico) {
		this.stockActual = stock;
		this.stockCritico = critico;
		this.stockMinimo = minimo;
	}

	private int getStockActual() {
		return stockActual;
	}

	private void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	/**
	 * Denota la cantidad actual de stock.
	 * 
	 * @return
	 */
	public int stock() {
		return this.getStockActual();
	}

	/**
	 * Denota true si se encuentra en estock el valor cantidad, Caso
	 * contrario false
	 * 
	 * @param cantidad
	 * @return
	 */
	public boolean enStock(int cantidad) {
		return this.getStockActual() >= cantidad;
	}

	/**
	 * Proposito: Agrega cantidad al stock.
	 * 
	 * @param cantidad
	 *            nueva cantidad agregada al stock
	 */
	public void agregarStock(int cantidad) {
		this.setStockActual(this.getStockActual() + cantidad);
		// Se notifica a los observers sobre el cambio actual del stock.
		this.setChanged();
		this.notifyObservers(this.getStockActual());
	}

	/**
	 * Proposito: Decrementa el stock cantidad de unidades
	 * 
	 * @param cantidad
	 *            cantidad a decrementar de stock
	 */
	public void decrementarStock(int cantidad)
			throws StockInsuficienteException {
		if (this.enStock(cantidad)){
			this.setStockActual(this.getStockActual() - cantidad);
		}else{
			throw new StockInsuficienteException();
		}
	}

	/**
	 * Propostio: Denota el punto en el que se alcanza el stock critico.
	 * 
	 * @return
	 */
	public int critico() {
		return this.stockCritico;
	}

	/**
	 * Proposito: Denota el punto en el que se alcanza el stock minimo.
	 * 
	 * @return
	 */
	public int minimo() {
		return this.stockMinimo;
	}
}
