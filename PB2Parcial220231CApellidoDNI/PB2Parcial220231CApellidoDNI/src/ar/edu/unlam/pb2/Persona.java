package ar.edu.unlam.pb2;

import java.util.Objects;

public class Persona implements Comparable<Persona>  {
	
	protected Integer dni;
	protected String nombre;
	protected String apellido;
	protected String apodo;
	
	public Persona(Integer dni, String nombre, String apellido, String apodo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.apodo = apodo;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public int compareTo(Persona o) {
		return this.getApodo().compareTo(o.apodo);
	}
	
	
	

	
	

	
	
}
