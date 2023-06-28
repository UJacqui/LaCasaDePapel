package ar.edu.unlam.pb2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Vigilancia {

	private String nombre;
	// Colocar el tipo de coleccion que corresponda
	private HashSet<Persona> personas = new HashSet<>();
	// Colocar el tipo de coleccion que corresponda
	private HashSet<Banco> bancos = new HashSet<>();
	//No se puede cambiar 
		private Map <Integer, Atraco> atracos = new HashMap<>();
		
//////////////////////////////////////////////////////////////////
	public Vigilancia(String nombre) {
		this.nombre = nombre;
	}
	
	
	public void agregarBanco(Banco banco) {
		this.bancos.add(banco);
	}
	public Integer cantBancosEnVigilancia() {
		return bancos.size();
	}
	
	
	

	/*
	 * Registra tanto como Vigiladores como atracadores no permite registrar 2
	 * personas con el mismo DNI. Si esto sucede lanza una exception
	 * PersonaDuplicadaException
	 * 
	 */
	
	public void registrarPersona(Persona persona) throws PersonaDuplicadaException {
		
		if(personas.size() == 0) {
			this.personas.add(persona);
			}else {
				for (Persona persona1 : personas) {
					if (persona1.getDni() == persona.getDni() ) {
						
						throw new PersonaDuplicadaException("personas con el mismo dni");
						
					} else {
						this.personas.add(persona);
					}
				}		
			}
	}
	
	public Integer cantPersonasRegistradas() {
		return personas.size();
	}


	
	/*
	 * Este Metodo lanza las siguientes Excepciones NoSeEncuentraAtracadorException
	 * BancoNoEncontradoExcecption
	 * 
	 */
	
	public void registrarAtraco(Integer dniAtracador, Integer idBanco) throws BancoNoEncontradoExcecption, NoSeEncuentraAtracadorException {
	 Atracador atracador = buscarAtracadorPorDni(dniAtracador);
	 Banco banco = buscarBancoPorId(idBanco);
	 
	 // Crear un nuevo atraco con el atracador y el banco encontrados
     Atraco atraco = new Atraco(1, atracador, banco);
     
     Integer clave = atraco.getClaveAtraco();
     //Se debe agregar un atraco al Mapa
     atracos.put(clave, atraco);
	
		 
	}
	
	public Integer cantRegistroAtraco() {
		return atracos.size();
		
	}
	

	
	public Banco buscarBancoPorId(Integer idBanco) throws BancoNoEncontradoExcecption {
		for (Banco banco : bancos) {
			if (banco.getIdBanco().equals(idBanco)) {
				return banco;
			}
		}
		throw new BancoNoEncontradoExcecption("idbanco no valido");
	}


	public Atracador buscarAtracadorPorDni(Integer dniAtracador) throws NoSeEncuentraAtracadorException {
		for (Persona persona1 : personas) {
			if (persona1.getDni().equals(dniAtracador)) {
				return (Atracador) persona1;
			}
		}
		throw new NoSeEncuentraAtracadorException("atracador no encontrado");
	}


	//Si la clave no existe lanza ClaveInexistenteException
	public Atraco buscarAtracoPorClave(Integer claveAtraco) throws ClaveInexistenteException {
		
		if(atracos.containsKey(claveAtraco)) {
			
			return atracos.get(claveAtraco);
		}
		

		throw new ClaveInexistenteException("no exite atraco");
	}


	public TreeSet<Persona> obtenerAtracadoresOrdenadosPorApodos() {
		
		TreeSet<Persona> variableOrden = new TreeSet<>(new OrdenPorApodos());
						variableOrden.addAll(personas);
		
		return variableOrden;
	}


	
	
//	public Vigilante obtenerElVigiladorDeUnAtraco(Integer claveAtraco) {
//
//		
//		Vigilante vigilante;
//		
//		
//		
//		return vigilante;
//		
//		
//		
//	}

	
//	public Set<Atracador> obtenerAtracadoresOrdenados(OrdenPorApodos ordenPorApodo ){
//		
//		Set<Atracador> atracadoresOrdenadados;
//		
//		
//		return atracadoresOrdenadados;
//	}
//	
//	

}
