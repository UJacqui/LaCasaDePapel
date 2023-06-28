package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class TestSistema {


	@Test
	public void testQueSePuedaRegistrarUnBanco() {
		Vigilancia vigilancia = new Vigilancia ("Nombre De la Compania de Vigilancia");
			
		
		Integer idbanco=1;
		Banco banco = new Banco("la Casa de Papel", idbanco);
		vigilancia.agregarBanco (banco);
		
		Integer bancosAgregadosEsperados = 1;
		Integer bancosObtenidos = vigilancia.cantBancosEnVigilancia();
		
		assertEquals(bancosAgregadosEsperados, bancosObtenidos);
		
	}
	
	@Test
	public void quePuedaRegistrarUnAtracador() throws PersonaDuplicadaException {
		Vigilancia vigilancia = new Vigilancia ("Nombre De la Compania de Vigilancia");
			//Creo Atracador
		Persona atracador = new Atracador (1, "Ursula", "Corbero","Tokio" );
		vigilancia.registrarPersona (atracador);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = vigilancia.cantPersonasRegistradas();
		
		//Compleatar el Assert
		
		assertEquals(valorEsperado, valorObtenido);

	}
//	
	
	@Test (expected=PersonaDuplicadaException.class)
	public void queCuandoSeRegistre2PersonasConElMismoDNiLanceUnaExpcionPersonaDuplicadaException() throws PersonaDuplicadaException {
		Vigilancia vigilancia = new Vigilancia ("Nombre De la Compania de Vigilancia");
		//Creo Vigilante
		Persona vigilante = new Vigilante (1, "juancarlos","Pepito", "Pistolero");
		//Creo Atracador
		Persona atracador = new Atracador (1, "Ursula", "Corbero","Tokio" );
		vigilancia.registrarPersona (atracador);
		vigilancia.registrarPersona (vigilante);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = vigilancia.cantPersonasRegistradas();
		
		//Compleatar el Assert
		
		assertEquals(valorEsperado, valorObtenido);
	}
//	
//
	@Test
	public void queSePuedaRegistraUnAtraco () throws PersonaDuplicadaException, ClaveInexistenteException, BancoNoEncontradoExcecption, NoSeEncuentraAtracadorException {	
		Vigilancia vigilancia = new Vigilancia ("Nombre De la Compania de Vigilancia");
		
		Integer idBanda = 1;
		String nombre="La Casa de Papel";
		Banda banda = new Banda (idBanda,nombre);
		
		Integer dni= 1;
		String nombres ="Ursula";
		String apellido= "Corbero";
		String apodo="Tokio";
		//No Cambiar esta Linea
		Persona atracador = new Atracador (dni, nombres, apellido,apodo );
		vigilancia.registrarPersona (atracador);
		
	
		Banco banco = new Banco("la Casa de Papel",1);
		vigilancia.agregarBanco (banco);
			
		vigilancia.registrarAtraco(dni, 1);

		
		Integer claveAtraco = 1;
		Atraco atraco =vigilancia.buscarAtracoPorClave(claveAtraco);
		
		Banco bancoEsperado = vigilancia.buscarBancoPorId(1);
		
		//No cambiar
		assertTrue(bancoEsperado.equals(atraco.getBanco()) );
		
		
	}
	
	
//	
//	
//
	@Test
	private void queSePuedaObtenerLosAtracadoresOrdenadosPorApodos() throws PersonaDuplicadaException {
		Vigilancia vigilancia = new Vigilancia ("Nombre De la Compania de Vigilancia");

		Persona atracador1 = new Atracador (40081194, "pedro", "alfonso","berlin" );
		Persona atracador2 = new Atracador (12345678, "alba", "flores","niarobi" );
		Persona atracador3 = new Atracador (78945612, "jaime", "lorente","denver" );

		vigilancia.registrarPersona (atracador1);
		vigilancia.registrarPersona (atracador2);
		vigilancia.registrarPersona (atracador3);
		
		TreeSet<Persona> atracadoresOrdenados = vigilancia.obtenerAtracadoresOrdenadosPorApodos();
		
		//assertEquals(atracadoresOrdenados.first(),atracador2);

	}
//	
////Cree un 3 test a su eleccion para que pruebe el resto de las funcionalidades
//	@Test
//	private void testSignificativo1() {
//		
//	}
//	
//	@Test
//	private void testSignificativo2() {
//		
//	}
//	
//	@Test
//	private void testSignificativo3() {
//		
//	}
//	

}
