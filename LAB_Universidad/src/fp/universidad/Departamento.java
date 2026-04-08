package fp.universidad;

import java.util.ArrayList;
import java.util.List;

import fp.utilities.Checkers;

public class Departamento {
	
	private List<Profesor> profesores;
	private List<Asignatura> asignaturas;
	private String nombre;
	
	
	// CONSTRUCTOR
	
	public Departamento(String nombre) {
		super();
		this.nombre = nombre;
		this.asignaturas = new ArrayList<Asignatura>();
		this.profesores = new ArrayList<Profesor>();
	}
	
	// FUNCIONES ADICIONALES
	
	public void nuevoProfesor(Profesor profesor) {
		profesores.add(profesor);
	}
	
	public void nuevaAsignatura(Asignatura asignatura) {
		asignaturas.add(asignatura);
	}
	
	public void eliminaProfesor(Profesor profesor) {
		Checkers.check("PROFESOR NO ENCONTRADO", profesores.contains(profesor));
		profesores.remove(profesores.indexOf(profesor));
	}
	
	public void eliminaAsignatura(Asignatura asignatura) {
		Checkers.check("ASIGNATURA NO ENCONTRADA", asignaturas.contains(asignatura));
		asignaturas.remove(asignaturas.indexOf(asignatura));
	}
	
	public void borraTutorias() {
		for (Profesor profesor : profesores) {
			profesor.borraTutorias();
		}
	}
	
	public void borraTutorias(Categoria categoria) {
		for(Profesor profesor : profesores) {
			if (profesor.getCategoria().equals(categoria)) profesor.borraTutorias();
		}
	}

	@Override
	public String toString() {
		return "Departamento:" + nombre;
	}
	
	
	

}
