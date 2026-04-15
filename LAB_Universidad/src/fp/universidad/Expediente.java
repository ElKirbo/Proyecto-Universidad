package fp.universidad;

import java.util.ArrayList;
import java.util.Objects;

public class Expediente {
	// ATRIBUTOS
	
	private ArrayList<Nota>  notas;
	
	// CONSTRUCTOR

	public Expediente() {
		super();
		this.notas = new ArrayList<Nota>();
	}

	
	// GETTER
	
	
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	
	// TOSTRING


	@Override
	public String toString() {
		return notas.toString();
	}
	
	// FUNCIONES ADICIONALES
	
	public Double notaMedia() {
		
		if (notas.isEmpty()) {
			return 0.0;
		}
		
		double suma = 0.0;
		int cont = 0;
		for (Nota n : notas) {
			if (n.valor() <= 5) suma += n.valor();
			cont++;
		}
		
		Double res = suma/cont;
		return res;
	}
	
	public void nuevaNota(Nota n) {
		if (notas.contains(n)) notas.remove(n);
		notas.add(n);
	}


	@Override
	public int hashCode() {
		return Objects.hash(notas);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expediente other = (Expediente) obj;
		return Objects.equals(notas, other.notas);
	}
	
	
	
	
	
	
	

}
