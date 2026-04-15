package fp.universidad;
import fp.utilities.Checkers;
import fp.utilities.Validators;
import java.time.LocalDate;
import java.util.Objects;

public class Persona implements Checkers, Validators{
	// ATRIBUTOS
	 private String dni;
	 private String nombre;
	 private String apellidos;
	 private LocalDate fechaNacimiento;
	 private String email;
	 
	 //CONSTRUCTOR CON EMAIL
	 public Persona(String dni, String nombre,String apellidos, LocalDate fechaNacimiento, String email) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	 }
	 
	 // CONSTRUCTOR SIN EMAIL
	 public Persona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		this(dni,nombre,apellidos,fechaNacimiento,"");
	 }
	 
	 // RESTRICCIONES
	 
	 private Boolean validoDNI(String cadena) {
		 return (cadena.length() == 9) && (Validators.sonDigitos(cadena.substring(0,8))) &&
				 (Character.isLetter(cadena.charAt(8)));
	 }
	 
	 private Boolean validoEmail(String cadena) {
		 return (cadena == null) || (cadena.indexOf("@") != -1);
	 }
	 
	 //SETTERS Y GETTERS

	 public String getDni() {
		 return dni;
	 }

	 public void setDni(String dni) {
		 Checkers.check("DNI INVALIDO", validoDNI(dni));
		 this.dni = dni;
	 }

	 public String getNombre() {
		 return nombre;
	 }

	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }

	 public LocalDate getFechaNacimiento() {
		 return fechaNacimiento;
	 }

	 public void setFechaNacimiento(LocalDate fechaNacimiento) {
		 this.fechaNacimiento = fechaNacimiento;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 Checkers.check("EMAIL INVALIDO", validoEmail(email));
		 this.email = email;
	 }
	 
	 @Override
	 public String toString() {
		return  dni + "-" + nombre + "-" + fechaNacimiento;
	 }

	 @Override
	 public int hashCode() {
		return Objects.hash(dni, email, nombre);
	 }
	 
	 
	 // EQUALS

	 @Override
	 public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(email, other.email)
				&& Objects.equals(nombre, other.nombre);
	 }
	 
	 public int compareTo(Persona o) {
		 int res = this.apellidos.compareTo(o.apellidos);
		 if (res == 0) { 
			 this.nombre.compareTo(o.nombre);
		 }
		 if (res == 0) {
			 this.dni.compareTo(o.dni);
		 }
		 return res;
	 }
	 
	 
	 
	 

}
