package vistas;

import java.util.HashMap;
import java.util.Scanner;

import dominio.Alumno;

public abstract class MenuTemplate {

	public Scanner scanner = new Scanner(System.in);
	int opcion = 0;
	
	boolean cargarDatos(){
		return false;
	}
	
	void exportarDatos(){
		
	}
	
	void crearAlumno(){
		
	}
	boolean agregarMateria(){
		return false;
	}
	
	boolean agregarNotaPasoUno() {
		return false;
	}
	
	void listarAlumnos(HashMap<String, Alumno> mapa){
		
	}
	
	void terminarPrograma(){
		System.out.println("Cerrando Programa...");
		//cerrar archivos
		System.exit(0);
	}


	
}
