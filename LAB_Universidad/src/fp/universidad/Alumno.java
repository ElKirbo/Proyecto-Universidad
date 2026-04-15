package fp.universidad;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

import fp.utilities.Checkers;

public class Alumno extends Persona implements Comparable<Alumno> , Checkers {
	
	private HashSet<Asignatura> asignaturas;
	private int curso;
	
	// RESTRICCIONES
	
	private Boolean emailValido( String cadena) {
		return (cadena.contains("@alum.us.es") || cadena.isEmpty());
	}

	public Alumno(String dni, String nombre,String apellidos, LocalDate fechaNacimiento, String email,
			int curso) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
		Checkers.check("EMAIL NO VALIDO", emailValido(super.getEmail()));
		this.asignaturas = new HashSet<Asignatura>();
		this.curso = getCurso();
	}
	
	public int compareTo(Alumno o) {
		return super.compareTo(o);
	}
	
	
	
	// FUNCIONES ADICIONALES
	
		public void agregarAsignatura(Asignatura a) {
			if (!asignaturas.contains(a)) asignaturas.add(a);
			else throw new IllegalArgumentException();
		}
		
		public void eliminaAsignatura(Asignatura a) {
			if (!asignaturas.contains(a)) asignaturas.remove(a);
			else throw new IllegalArgumentException();
		}
		
		
		public Boolean estaMatriculadoEn(Asignatura a) {
			Boolean res = false;
			for (Asignatura i : asignaturas) {
				if (i.equals(a)) res = true;
			}
			return res;
		}
		
		public Integer getCurso() {
			Integer res = 0;
			if (!asignaturas.isEmpty()) {
				Asignatura c = Collections.max(asignaturas, Comparator.comparing(Asignatura::curso));
				res = c.curso();
			}
			return res;
		}
		
		
		
	@Override
	public String toString() {
		return "Alumno [curso=" + curso + ", getDni()=" + getDni() + ", getNombre()=" + getNombre()
				+ ", getFechaNacimiento()=" + getFechaNacimiento() + "]";
	}
	
	
	
	

}
