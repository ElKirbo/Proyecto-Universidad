package fp.universidad;

import java.util.HashSet;
import java.util.Objects;

import fp.utilities.Checkers;

public class Centro implements Comparable<Centro> {
	
	// ATRIBUTOS
	
	private String nombre;
	private String direccion;
	private Integer plantas;
	private Integer sotanos;
	private HashSet<Espacio> espacio;
	
	private Boolean plantasValidas(Integer planta) {
		return (plantas >= 1);
	}
	
	private Boolean sotanosValidos(Integer sotanos) {
		return (sotanos >= 0);
	}
	
	// CONSTRUCTOR
	
	public Centro(String nombre, String direccion, Integer plantas, Integer sotanos) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		Checkers.check("NUMERO DE PLANTAS INVALIDA", plantasValidas(plantas));
		this.plantas = plantas;
		Checkers.check("NUMERO DE SOTANOS INVALIDO", sotanosValidos(sotanos));
		this.sotanos = sotanos;
		this.espacio = new HashSet<Espacio>();
	}
	
	// GETTERS

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public Integer getPlantas() {
		return plantas;
	}

	public Integer getSotanos() {
		return sotanos;
	}

	public HashSet<Espacio> getEspacio() {
		return espacio;
	}
	
	// FUNCIONES ADICIONALES
	
	public void nuevoEspacio(Espacio e) {
		int plantas = e.getPlanta();
		if ((plantas < -sotanos) || (plantas > plantas)) throw new IllegalArgumentException("PLANTA FUERA DE RANGO");
		espacio.add(e);
	}
	
	public void eliminarEspacio(Espacio e) {
		if (!espacio.contains(e)) throw new IllegalArgumentException("ESPACIO NO ENCONTRADO");
		else espacio.remove(e);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centro other = (Centro) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public int compareTo(Centro otro) {
		return this.nombre.compareTo(otro.nombre);
	}
	
	
	
	

}
