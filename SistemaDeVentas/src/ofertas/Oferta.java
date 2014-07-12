package ofertas;

public abstract class Oferta {
	private Double porcentajeDescuento;

	protected Oferta(Double descuento) {
		this.porcentajeDescuento = descuento;
	}


	/**
	 * Denota el porcentaje de descuento sobre la oferta.
	 * @return
	 */
	public Double descuento(){
		return porcentajeDescuento; 
	}
	
	/**
	 * Denota el precio sin aplicar la oferta.
	 * @return
	 */
	public abstract Double precioNormal();
	
	/**
	 * Denota el precio final de la oferta (sin aplicar el descuento)
	 * @return
	 */
	public abstract Double precioOferta();
	
	
}
