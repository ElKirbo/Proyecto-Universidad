package fp.universidad;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

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
	
	/**
	 * @return the profesores
	 */
	public List<Profesor> getProfesores() {
		return profesores;
	}

	/**
	 * @return the asignaturas
	 */
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

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
	
	public SortedMap<Asignatura,SortedSet<Profesor>> getProfesoresPorAsignatura(){
		SortedMap<Asignatura,SortedSet<Profesor>> res = new TreeMap<Asignatura,SortedSet<Profesor>>();
		SortedSet<Profesor> lista = new TreeSet<Profesor>();
		
		for(Asignatura a: asignaturas) {
			for(Profesor p: profesores) {
				List<Asignatura> dedicacion = p.getAsignaturas();
				if(dedicacion.contains(a) && !res.containsKey(a)) {
					lista.add(p);
					res.put(a, lista);
				} else if (dedicacion.contains(a) && res.containsKey(a)) {
					SortedSet<Profesor> nuevaLista = res.get(a);
					nuevaLista.add(p);
					res.put(a, nuevaLista);
				}
			}
		}
		
		return res;
	}
	
	public SortedMap<String, SortedSet<Tutoria>> getTutoriasPorProfesor(){
		SortedMap<String, SortedSet<Tutoria>> res = new TreeMap<String, SortedSet<Tutoria>>();
		
		for(Profesor p: profesores) {
			String clave = p.toString();
			if (!res.containsKey(clave)) {
				SortedSet<Tutoria> conjuntoTutorias = new TreeSet<Tutoria>(p.getTutorias());
				res.put(clave, conjuntoTutorias);
			}
		}
		
		return res;
	}
	
	
	

}
