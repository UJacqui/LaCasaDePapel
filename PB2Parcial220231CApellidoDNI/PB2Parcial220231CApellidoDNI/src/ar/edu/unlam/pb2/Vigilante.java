package ar.edu.unlam.pb2;

public class Vigilante extends Persona {
	
	public Vigilante(Integer dni, String nombre, String apellido, String apodo) {
		super(dni, nombre, apellido, apodo);
		// TODO Auto-generated constructor stub
	}

	private Banco banco;
	
	
	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	
	
	
	
	
	

}
