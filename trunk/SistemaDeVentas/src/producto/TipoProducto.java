package producto;

public class TipoProducto {
	String tipo;
	
	private void setTipo(String nuevoTipo){
		this.tipo=nuevoTipo;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public TipoProducto(String tipo){
		this.setTipo(tipo);
	}
}
