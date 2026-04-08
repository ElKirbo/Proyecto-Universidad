package fp.universidad;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

public record Tutoria(DayOfWeek dia_semana, LocalTime hora_comienzo, LocalTime hora_fin, Long minutos) {
	
	// FUNCION MINUTOS
	
	private Long parseaMinutos(LocalTime comienzo, LocalTime fin) {
		Long minutos = Duration.between(fin,comienzo).toMinutes();
		return minutos;
	}
	
	// CONSTRUCTOR
	
	public Tutoria(DayOfWeek dia_semana, LocalTime hora_comienzo, LocalTime hora_fin) {
		this(dia_semana,hora_comienzo,hora_fin,null);
	}
	
	public Tutoria(DayOfWeek dia_semana, LocalTime hora_comienzo, Long duracion) {
		this(dia_semana,hora_comienzo,null,duracion);
	}

	// GETTERS
	
	public DayOfWeek dia_semana() {
		return dia_semana;
	}

	public LocalTime hora_comienzo() {
		return hora_comienzo;
	}

	public LocalTime hora_fin() {
		return hora_fin;
	}

	public Long minutos() {
		Long minutos = parseaMinutos(hora_comienzo,hora_fin);
		return minutos;
	}
	
	// EQUALS

	@Override
	public int hashCode() {
		return Objects.hash(dia_semana, hora_comienzo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutoria other = (Tutoria) obj;
		return dia_semana == other.dia_semana && Objects.equals(hora_comienzo, other.hora_comienzo);
	}
	
	
	

}




