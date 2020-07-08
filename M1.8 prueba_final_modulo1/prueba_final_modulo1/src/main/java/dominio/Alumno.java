package dominio;

import java.util.ArrayList;


public class Alumno {
	
	public String nombre;
	public String rut;
	public String apellido;
	public String direccion;
	public ArrayList<Materia> listaMateria;
	
	
	public Alumno () {
		this.listaMateria = new ArrayList<Materia>();
	}


	public Alumno(String rut, String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.listaMateria = new ArrayList();
	}


	@Override
	public String toString() {
		return nombre + ", " + rut + ", listaMateria=" + listaMateria;
	}

	
	
}
