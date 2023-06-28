package ar.edu.unlam.pb2;

public class Atracador extends Persona {
	
	public Atracador(Integer dni, String nombre, String apellido, String apodo) {
		super(dni, nombre, apellido, apodo);
		// TODO Auto-generated constructor stub
	}

	private Banda banda;

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}
	
	
	

}
