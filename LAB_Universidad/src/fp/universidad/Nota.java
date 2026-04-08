package fp.universidad;

public record Nota(String nombre, Integer anyo, Convocatoria convocatoria, Double valor, Calificacion calificacion, Boolean honor) {
	
	public Nota(String nombre, Integer anyo, Convocatoria convocatoria, Calificacion calificacion, Double valor, Boolean honor) {
		this(nombre,anyo,convocatoria,valor,calificacion,honor);
	}
	
	private Calificacion notaCalificacion(Double valor) {
		Calificacion res = Calificacion.MATRICULA_DE_HONOR;
		
		if (valor < 5) res = Calificacion.SUSPENSO;
		if ((valor >= 5) && (valor < 7)) res = Calificacion.APROBADO;
		if ((valor >= 7) && (valor < 9)) res = Calificacion.NOTABLE;
		if ((valor >= 9) && (valor < 9.5)) res = Calificacion.SOBRESALIENTE;
		return res;
		
	}
	
			

	private String getCurso(Integer anyo) {
		int anyoFin = (anyo + 1) % 100;
		return String.format("%d-%02d", anyo, anyoFin);
		
	}

	@Override
	public String toString() {
		return "[" + nombre + "," + getCurso(anyo) + "," + convocatoria + "," + valor + "," + notaCalificacion(valor) + "]";
				
	}

	
	
	
	
	

}
