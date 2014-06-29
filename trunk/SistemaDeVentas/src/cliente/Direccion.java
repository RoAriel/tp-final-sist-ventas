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
	
	public Direccion(String calle,String numero){
		//this.Direccion(calle,numero," "," ");
		this.calle = calle;
		this.numero =numero;
		this.piso = " ";
		this.departamento = " ";
	}
	
	public String calle(){
		return calle;
	}
	
	public String numero(){
		return numero;
	}
	
	public String piso(){
		return piso;
	}
	
	public String departamento(){
		return departamento;
	}
}
