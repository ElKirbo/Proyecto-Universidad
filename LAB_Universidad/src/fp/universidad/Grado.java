package fp.universidad;

import java.util.HashSet;
import java.util.Objects;

import fp.utilities.Checkers;

public class Grado implements Comparable<Grado>{
	
	// ATRIBUTOS
	
	private String nombre;
	private HashSet<Asignatura> obligatorias;
	private HashSet<Asignatura> optativas;
	private Double mincreditos;
	private Double media;
	
	// RESTRICCIONES
	
	private Boolean creditosValidos(HashSet<Asignatura> lista) {
		Boolean res = true;
		if(!lista.isEmpty()) {
			double referencia = lista.iterator().next().creditos();
			for(Asignatura a : lista) {
				if (referencia != a.creditos()) res = false;  
			}
		}
		else throw new IllegalArgumentException("LISTA VACIA");
		return res;
	}
	
	private Boolean notaValida(HashSet<Asignatura> lista) {
		Boolean res = true;
		Double total = 0.0;
		if(!lista.isEmpty()) {
			for (Asignatura a: lista) {
				total += a.creditos();
			}
			
			for (Asignatura a : lista) {
				if ((0 <= a.creditos()) && (a.creditos() > total)) {
					res = false;
					break;
				}
			}
		}
		return res;
	}

	// CONSTRUCTOR
	
	public Grado(String nombre, HashSet<Asignatura> obligatorias, HashSet<Asignatura> optativas, Double mincreditos,
			Double media) {
		super();
		this.nombre = nombre;
		this.obligatorias = obligatorias;
		this.optativas = optativas;
		Checkers.check("EL NUMERO DE CREDITOS DE LAS OPTATIVAS NO ES EL MISMO", creditosValidos(optativas));
		Checkers.check("UNA DE LAS NOTAS DE LAS OPTATIVAS NO ES VALIDA", notaValida(optativas));
		this.mincreditos = mincreditos;
		this.media = mediaNota(obligatorias);
	}
	

	// EQUALS Y COMPARABLE

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
		Grado other = (Grado) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	public int compareTo(Grado otro) {
		return this.nombre.compareTo(otro.nombre);
	}
	
	// FUNCION ADICIONAL
	
	private Double mediaNota(HashSet<Asignatura> lista) {
		Double res = 0.0;
		Double longitud = (double) lista.size();
		
		for(Asignatura a : lista) {
			res += a.creditos();
		}
		
		res = (res + mincreditos)/longitud;
		return res;
	}
	
	
	
	
	
	

}
