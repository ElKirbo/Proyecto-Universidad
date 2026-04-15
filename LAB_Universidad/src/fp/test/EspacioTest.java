package fp.test;

import fp.universidad.Espacio;
import fp.universidad.TipoEspacio;

public class EspacioTest {
	
	public static void main(String[] args) {
		Espacio espacio1 = new Espacio(TipoEspacio.TEORIA,"A3.10",34,3);
		
		System.out.println(espacio1);
	}

}
