package producto;

public class UnidadDeMedida {
	private String tipo;
	private Double cantidad;

	protected void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getTipo() {
		return tipo;
	}
	private void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Double cantidad(){
		return this.cantidad;
	}
	
	public UnidadDeMedida(String tipo,Double cantidad){
		this.setTipo(tipo);
		this.setCantidad(cantidad);
	}
	
	public String tipoDeUnidadYCantidad(){
		return  "Presentacion en "+this.getTipo()+". Cantidad: "+this.cantidad();
	}
	
}
