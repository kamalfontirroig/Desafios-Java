package dominio;

import java.util.ArrayList;

public class Materia{
	
	public Materias nombreMateria;
	public ArrayList<Float> notas;
	public Float promedio;
	public static int cantidadDeMaterias = 4;
	public enum Materias {
		MATEMATICAS,
		HISTORIA,
		LENGUAJE,
		CIENCIAS		
	}

	public Materia() {
		super();
		this.notas = new ArrayList<Float>();
	}
	@Override
	public String toString() {
		return "Materia [nombreMateria=" + nombreMateria + ", notas=" + notas + ", promedio=" + promedio + "]";
	}
	
	

}
