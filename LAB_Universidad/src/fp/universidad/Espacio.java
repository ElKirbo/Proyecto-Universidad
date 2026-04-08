package fp.universidad;
import java.util.Objects;

import fp.utilities.Checkers;
public class Espacio implements Checkers , Comparable<Espacio> {
	
	// ATRIBUTOS
	
	private TipoEspacio tipo;
	private String nombre;
	private Integer capacidad;
	private Integer planta;
	
	// CONSTRUCTOR
	
	public Espacio(TipoEspacio tipo, String nombre, Integer capacidad, Integer planta) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
	}
	
	public Espacio(String cadena) {
		String[] trozos = cadena.split(",");
		Checkers.check("La cadena no se trocea bien", trozos.length == 4);
		
		this.nombre = trozos[0].trim();
		this.planta = Integer.getInteger(trozos[1].trim());
		this.capacidad = Integer.getInteger(trozos[2].trim());
		this.tipo = TipoEspacio.valueOf(trozos[3].trim());
		
	}
	
	// RESTRICCIONES
	
	private Boolean capacidadValida(Integer numero) {
		Boolean res = false;
		if (numero > 0) res = true;
		return res;
	}
	
	// GETTERS Y SETTERS

	public TipoEspacio getTipo() {
		return tipo;
	}

	public void setTipo(TipoEspacio tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		Checkers.check("CAPACIDAD INVALIDA", capacidadValida(capacidad));
		this.capacidad = capacidad;
	}

	public Integer getPlanta() {
		return planta;
	}

	@Override
	public String toString() {
		return "[" + nombre + " (planta" + planta + ")]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, planta);
	}

	
	// EQUALS
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espacio other = (Espacio) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(planta, other.planta);
	}
	
	public int compareTo(Espacio o) {
		int r = this.planta.compareTo(o.planta);
		if (r == 0) r = this.nombre.compareTo(o.nombre);
		return r;
	}
	
	
	
	
	
	
	
	
	
	
	

}
