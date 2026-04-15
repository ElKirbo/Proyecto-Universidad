package fp.universidad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fp.utilities.Checkers;

public class FactoriaUniversidad {
	
	public static List<Espacio> leerLibros(String fichero){
		List<Espacio> res = new ArrayList<Espacio>();
		
		try {
			List<String> lineas = Files.readAllLines(Paths.get(fichero));
			for(String linea: lineas) {
				res.add(new Espacio(linea));
			}
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static List<Despacho> leerDespacho(String fichero){
		List<Despacho> res = new ArrayList<Despacho>();
		
		try {
			List<String> lineas = Files.readAllLines(Paths.get(fichero));
			for (String linea: lineas) {
				res.add(new Despacho(linea));
			}
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static List<Asignatura> leerAsignatura(String fichero){
		List<Asignatura> res = new ArrayList<Asignatura>();
		
		try {
			List<String> lineas = Files.readAllLines(Paths.get(fichero));
			for (String linea: lineas) {
				res.add(crearAsignatura(linea));
				
			}
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static Asignatura crearAsignatura(String cadena) {
		String[] trozos = cadena.split("#");
		Checkers.check("La cadena no trozea bien", trozos.length == 5);
		
		String nombre = trozos[0].trim();
		String codigo = trozos[1].trim();
		Double creditos = Double.valueOf(trozos[2].trim());
		TipoAsignatura tipo = TipoAsignatura.valueOf(trozos[3].trim());
		Integer curso = Integer.valueOf(trozos[4].trim());
		
		return new Asignatura(nombre,codigo,creditos,tipo,curso);
	}
	
	public static List<Nota> leerNota(String fichero){
		List<Nota> res = new ArrayList<Nota>();
		
		try {
			List<String> lineas = Files.readAllLines(Paths.get(fichero));
			for(String linea: lineas) {
				res.add(crearNota(linea));
			}
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static Nota crearNota(String cadena) {
		String[] trozos = cadena.split("#");
		Checkers.check("La cadena no trozea bien", trozos.length == 6);
		
		String nombre = trozos[0].trim();
		Integer anyo = Integer.valueOf(trozos[1].trim());
		Convocatoria convocatoria = Convocatoria.valueOf(trozos[2].trim());
		Double valor = Double.valueOf(trozos[3].trim());
		Calificacion calificacion = Calificacion.valueOf(trozos[4].trim());
		Boolean honor = Boolean.valueOf(trozos[5].trim());
		
		return new Nota(nombre,anyo,convocatoria,valor,calificacion,honor);
	}

}
