package fp.universidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

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
	
	public Set<Asignatura> getAsignaturas(Integer curso){
		Set<Asignatura> res = new TreeSet<Asignatura>();
		
		for(Asignatura obligatoriaCurso : obligatorias) {
			if(obligatoriaCurso.curso().equals(curso)) res.add(obligatoriaCurso);
		}
		
		for(Asignatura optativaCurso : optativas) {
			if(optativaCurso.curso().equals(curso)) res.add(optativaCurso);
		}
		
		return res;
	}
	
	public Asignatura getAsignatura(String codigo) {
		Asignatura res = null;
		Set<Asignatura> asignaturas = new TreeSet<Asignatura>(obligatorias);
		asignaturas.addAll(optativas);
		
		for(Asignatura a : asignaturas) {
			if(a.codigo().equals(codigo)) {
				res = a;
				break;
			}
				
		}
		return res;
	}
	
	public List<Asignatura> getTodasAsignaturas() { // METODO AUXILIAR PARA getCreditosPorAsignatura()
		List<Asignatura> res = new ArrayList<Asignatura>(obligatorias);
		res.addAll(optativas);
		return res;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the obligatorias
	 */
	public HashSet<Asignatura> getObligatorias() {
		return obligatorias;
	}

	/**
	 * @param obligatorias the obligatorias to set
	 */
	public void setObligatorias(HashSet<Asignatura> obligatorias) {
		this.obligatorias = obligatorias;
	}

	/**
	 * @return the optativas
	 */
	public HashSet<Asignatura> getOptativas() {
		return optativas;
	}

	/**
	 * @param optativas the optativas to set
	 */
	public void setOptativas(HashSet<Asignatura> optativas) {
		this.optativas = optativas;
	}

	/**
	 * @return the mincreditos
	 */
	public Double getMincreditos() {
		return mincreditos;
	}

	/**
	 * @param mincreditos the mincreditos to set
	 */
	public void setMincreditos(Double mincreditos) {
		this.mincreditos = mincreditos;
	}
	
	public SortedMap<Asignatura, Double> getCreditosPorAsignatura(){
		SortedMap<Asignatura,Double> res = new TreeMap<Asignatura,Double>();
		List<Asignatura> listaAsignaturas = getTodasAsignaturas();
		
		for(Asignatura a: listaAsignaturas) {
			if(!res.containsKey(a)) {
				res.put(a, a.creditos());
			}
		}
		
		return res;
	}
	
	private Double CreditoCurso(Integer curso) { //FUNCION AUXILIAR PARA getTotalCreditosPorCurso
		Double res = 0.0;
		List<Asignatura> listaAsignaturas = getTodasAsignaturas();
		for(Asignatura a:listaAsignaturas) {
			if(a.curso().equals(curso)) res = res + a.creditos();
		}
		
		return res;
	}
	
	public Map<Integer, Double> getTotalCreditosPorCurso(){
		Map<Integer, Double> res = new HashMap<Integer,Double>();
		
		for(int i = 1; i < 5; i++) { // SABEMOS QUE UNA CARRERA DURA 4 AÑOS, ES DECIR, 4 CURSOS
			if(!res.containsKey(i)) {
				res.put(i, CreditoCurso(i));
			}
		}
		
		return res;
		
	}
	
	
	
	

}
