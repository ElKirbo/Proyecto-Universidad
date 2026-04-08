package fp.test;
import fp.universidad.Calificacion;
import fp.universidad.Convocatoria;
import fp.universidad.Nota;
public class NotaTest {
	
	public static void main(String[] args) {
		
		Nota nota1 = new Nota("Fundamentos de Programación",2014,Convocatoria.PRIMERA,10.0,Calificacion.SOBRESALIENTE,false);
		
		System.out.println(nota1);
	}
	

}
