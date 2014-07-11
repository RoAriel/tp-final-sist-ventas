package cliente;

public class Direccion {
	String calle;
	String numero;
	String piso;
	String departamento;
	
	public Direccion(String calle,String numero, String piso, String departamento){
		this.calle = calle;
		this.numero =numero;
		this.piso = piso;
		this.departamento = departamento;
	}
	
	/**
	 * Retorna la calle.
	 * @return String
	 */
	public String calle(){
		return calle;
	}
	
	/**
	 * Retorna el numero de 
	 * @return String
	 */
	public String numero(){
		return numero;
	}
	
	/**
	 * Retorna el piso.
	 * @return String
	 */
	public String piso(){
		return piso;
	}
	
	/**
	 * Retorna el departamento.
	 * @return String
	 */
	public String departamento(){
		return departamento;
	}
}
