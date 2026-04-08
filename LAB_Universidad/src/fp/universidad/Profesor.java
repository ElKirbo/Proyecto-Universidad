package fp.universidad;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.HashSet;

import fp.utilities.Checkers;

public class Profesor extends Persona implements Checkers, Comparable<Profesor> {
	
	private Categoria categoria;
	private HashSet<Tutoria> tutorias;
	
	// RESTRICCIONES
	
	private Boolean mayorEdad(LocalDate fecha) {
		Integer edad = Period.between(fecha, LocalDate.now()).getYears();
		return (edad < 18);
	}

	// CONSTRUCTOR
	
	
	public Profesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email,
			Categoria categoria, HashSet<Tutoria> tutorias) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
		Checkers.check("EDAD MENOR DE 18 AÑOS", mayorEdad(super.getFechaNacimiento()));
		this.categoria = categoria;
		this.tutorias = new HashSet<Tutoria>();
	}
	
	
	// EQUALS Y COMPARETO
	
	
	public Boolean equals(Profesor o) {
		return super.equals(o);
	}
	
	public int compareTo(Profesor o) {
		return super.compareTo(o);
	}
	
	
	// FUNCIONES ADICIONALES
	
	public void nuevaTutoria(LocalTime comienzo, Long duracion, DayOfWeek semana) {
		Tutoria tutoria = new Tutoria(semana,comienzo,duracion);
		tutorias.add(tutoria);
		
	}
	
	public void borraTutoria(LocalTime comienzo, Long duracion, DayOfWeek semana) {
		Tutoria tutoria = new Tutoria(semana,comienzo,duracion);
		for(Tutoria i : tutorias) {
			if (i.equals(tutoria)) tutorias.remove(i);
		}
	}
	
	public void borraTutorias() {
		tutorias.removeAll(tutorias);
	}

	@Override
	public String toString() {
		return "" + super.toString() + "" + categoria + ", tutorias=" + tutorias + "]";
	}

	public Categoria getCategoria() {
		return categoria;
	}

	
	public HashSet<Tutoria> getTutorias() {
		return tutorias;
	}
	
	
	

}






