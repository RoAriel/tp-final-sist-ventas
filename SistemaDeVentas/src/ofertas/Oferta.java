package ofertas;

public abstract class Oferta {
	private int porcentajeDescuento;

	protected Oferta(int descuento) {
		this.porcentajeDescuento = descuento;
	}

	protected int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	protected void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	/**
	 * Denota el porcentaje de descuento sobre la oferta.
	 * @return
	 */
	public int descuento(){
		return this.getPorcentajeDescuento(); 
	}
	
	/**
	 * Proposito: Denota el precio sin aplicar la oferta.
	 * @return
	 */
	public abstract Double precioNormal();
	
	/**
	 * Proposito: Denota el precio final de la oferta (sin aplicar el descuento)
	 * @return
	 */
	public abstract Double precioOferta();
	
	
}
