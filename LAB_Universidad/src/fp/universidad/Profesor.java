package fp.universidad;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import fp.utilities.Checkers;

public class Profesor extends Persona implements Checkers, Comparable<Profesor> {
	
	private Categoria categoria;
	private HashSet<Tutoria> tutorias;
	private Map<Asignatura, Double> creditos;
	private static final Double MAX_CREDITOS = 24.0;
	
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
		this.creditos = new HashMap<Asignatura, Double>();
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
		return "" + super.toString() + "(" + categoria +")";
	}

	public Categoria getCategoria() {
		return categoria;
	}

	
	public HashSet<Tutoria> getTutorias() {
		return tutorias;
	}
	
	public List<Asignatura> getAsignaturas(){
		return new ArrayList<Asignatura>(creditos.keySet());
	}
	
	public List<Double> getCreditos(){
		return new ArrayList<Double>(creditos.values());
	}
	
	public void imparteAsignatura(Asignatura asignatura,Double dedicacion) {
		Checkers.check("DEDICACION MENOR O IGUAL A 0", dedicacion >= 0);
		Checkers.check("DEDICACION MAYOR A CREDITOS DE LA ASIGNATURA", dedicacion <= asignatura.creditos());
		Checkers.check("DEDICACION MAYOR AL MAXIMO DE CREDITOS", dedicacion <= MAX_CREDITOS);
		
		creditos.put(asignatura, dedicacion);
	}
	
	public void eliminaAsignatura(Asignatura asignatura) {
		if (creditos.containsKey(asignatura)) creditos.remove(asignatura); 
	}
	
	public Double dedicacionAsignatura(Asignatura asignatura) {
		return creditos.getOrDefault(asignatura.creditos(),0.0);
	}
	
	public Double getDedicacionTotal() {
		Double res = 0.0;
		List<Double> valores = new ArrayList<Double>(creditos.values());
		for(Double v: valores) res += v;
		return res;
	}

}






