package ar.edu.unlam.pb2;


//No se puede modificar esta clase
public class Atraco {
	private Integer claveAtraco;
	private Atracador atracador;
	private Banco banco;
	
	public Atraco(Integer claveAtraco,Atracador atracador, Banco banco) {
		this.claveAtraco= claveAtraco;
		this.atracador=atracador;
		this.banco=banco;
	}
	public Integer getClaveAtraco() {
		return claveAtraco;
	}
	public void setClaveAtraco(Integer claveAtraco) {
		this.claveAtraco = claveAtraco;
	}
	public Atracador getAtracador() {
		return atracador;
	}
	public void setAtracador(Atracador atracador) {
		this.atracador = atracador;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	
	
	

}
