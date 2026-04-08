package fp.universidad;

import java.util.Objects;

import fp.utilities.Checkers;

public record Asignatura(String nombre,String codigo, Double creditos, TipoAsignatura tipo, Integer curso ) implements Checkers {
	
	private Boolean codigoValido(String cadena) {
		Boolean res = true;
		if ((cadena.length() > 7) || (cadena == null)) res = false;
		return res;	
	}
	
	private Boolean creditosValido(Double numero) {
		Boolean res = false;
		if (numero > 0) res = true;
		return res;
	}

	public Asignatura{
		Checkers.check("CODIGO INVALIDO", codigoValido(codigo));
		Checkers.check("NUMERO DE CREDITOS INVALIDO", creditosValido(creditos));		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public String nombre() {
		return nombre;
	}

	public String codigo() {
		return codigo;
	}

	public Double creditos() {
		return creditos;
	}

	public TipoAsignatura tipo() {
		return tipo;
	}
	
	public Integer curso() {
		return curso;
	}

	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", codigo=" + codigo + ", creditos=" + creditos + ", curso=" + curso
				+ "tipo =" + tipo + "]";
	}
	
	
	
	
	
	
	
	
	

}
