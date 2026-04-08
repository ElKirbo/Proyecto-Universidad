package fp.universidad;

import java.util.HashSet;

import fp.utilities.Checkers;

public class Despacho extends Espacio implements Checkers {
	
	private HashSet<Profesor> profesores;
	
	// RESTRICCIONES
	
	private Boolean cantidadProfesores(HashSet<Profesor> profesores) {
		return (profesores.size() < super.getCapacidad());
	}
	
	@Override
	public void setTipo(TipoEspacio tipo) {
		throw new UnsupportedOperationException("El tipo de espacio debe de ser 'Otro");
	}
	
	// CONSTRUCTORES
	
	public Despacho(String nombre, Integer capacidad, Integer planta, Profesor profesor) {
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		this.profesores = new HashSet<Profesor>();
		if (profesor != null) this.profesores.add(profesor);
	}

	public Despacho(TipoEspacio tipo, String nombre, Integer capacidad, Integer planta, HashSet<Profesor> profesores) {
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		this.profesores = profesores;
	}

	public Despacho(TipoEspacio tipo, String nombre, Integer capacidad, Integer planta) {
		super(TipoEspacio.OTRO, nombre, capacidad, planta);
		this.profesores = new HashSet<Profesor>();
	}
	
	public Despacho(String cadena) {
		super(cadena + ",OTRO");
		this.profesores = new HashSet<Profesor>();
		
		
		
	}
	
	// EQUALS
	
	public Boolean equals(Despacho o) {
		boolean r = super.equals(o);
		return r;
	}
	
	public Integer compareTo(Despacho o) {
		int r = super.compareTo(o);
		return r;
	}

	@Override
	public String toString() {
		return "(" + super.toString() + "" + profesores.toString() + "]";
	}
	
	
	
	

}
