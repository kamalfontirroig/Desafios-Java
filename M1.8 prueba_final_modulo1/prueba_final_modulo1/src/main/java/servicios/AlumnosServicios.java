package servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import dominio.Alumno;
import dominio.Materia;
import dominio.Materia.Materias;
import utilidades.Utilidad;
import utilidades.PromedioServicio;
import vistas.Menu;

public class AlumnosServicios {

	public HashMap<String, Alumno> mapaAlumnos;
	
	public AlumnosServicios() {
		super();
		this.mapaAlumnos = new HashMap<String, Alumno>();
	}

	public void crearAlumno(Alumno alumnoNuevo) {
		this.mapaAlumnos.put(alumnoNuevo.rut, alumnoNuevo);
	}
	public static Alumno crearAlumno() {
		Scanner scanner = new Scanner(System.in);
		Alumno nuevoAlumno = new Alumno();
		Utilidad.setCursor(40, 5);
		System.out.print("-------------------------------------------- Crear Alumno");
		Utilidad.setCursor(40, 6);
		System.out.print("RUT: ");
		Utilidad.setCursor(40, 7);
		System.out.print("NOMBRE COMPLETO: ");
		Utilidad.setCursor(40, 8);
		System.out.print("DIRECCION: ");
		Utilidad.setCursor(40, 9);
		System.out.print("---------------------------------------------");
		Utilidad.setCursor(6 + 40, 6);
		
		nuevoAlumno.rut = scanner.next();
		scanner.nextLine();
		Utilidad.setCursor(18 + 40, 7);
		nuevoAlumno.nombre = scanner.nextLine();
		Utilidad.setCursor(12 + 40, 8);
		nuevoAlumno.direccion = scanner.nextLine();
		return nuevoAlumno;
	}
	
	
	public boolean poseeMateria(Materias materia, Alumno alumno) {
		if (alumno != null)
		return (alumno.listaMateria.stream().anyMatch(materia_ -> materia_.nombreMateria.equals(materia)))?true:false;
		else return false;
		
	}

	public
	boolean agregarMateria(Menu menu) {
		Alumno alumnoTemporal = new Alumno();
		boolean exito = false;
		Materia materiaNueva = new Materia();
		Utilidad.setCursor(40, 5);
		System.out.print("-------------------------------------------- Agregar Materia");
		Utilidad.setCursor(40, 6);
		System.out.print("RUT: ");
		Utilidad.setCursor(40, 8);
		System.out.print("1. MATEMATICAS");
		Utilidad.setCursor(40, 9);
		System.out.print("2. LENGUAJE");
		Utilidad.setCursor(40, 10);
		System.out.print("3. CIENCIA");
		Utilidad.setCursor(40, 11);
		System.out.print("4. HISTORIA");
		Utilidad.setCursor(40, 12);
		System.out.print("Selecciona una Materia: ");
		Utilidad.setCursor(6 + 40, 6);
		String rut = menu.scanner.nextLine();
		alumnoTemporal = mapaAlumnos.get(rut);
		if(alumnoTemporal == null) return false;
		Utilidad.setCursor(24 + 40, 12);
		int materiaSeleccionada = (int) MenuServicio.validarEntrada(menu.scanner.next());
		menu.scanner.nextLine();
	
		switch (materiaSeleccionada) {
		case 1: {
			if (!alumnoTemporal.listaMateria.stream()
					.anyMatch(materia -> materia.nombreMateria.equals(Materias.MATEMATICAS))) {
				materiaNueva.nombreMateria = Materias.MATEMATICAS;
				exito = true;
			}
			break;
		}
		case 2: {
			if (!alumnoTemporal.listaMateria.stream()
					.anyMatch(materia -> materia.nombreMateria.equals(Materias.LENGUAJE))) {
				materiaNueva.nombreMateria = Materias.LENGUAJE;
				exito = true;
			}
			break;
		}
		case 3: {
			if (!alumnoTemporal.listaMateria.stream()
					.anyMatch(materia -> materia.nombreMateria.equals(Materias.CIENCIAS))) {
				materiaNueva.nombreMateria = Materias.CIENCIAS;
				exito = true;
			}
			break;
		}
		case 4: {
			if (!alumnoTemporal.listaMateria.stream()
					.anyMatch(materia -> materia.nombreMateria.equals(Materias.HISTORIA))) {
				materiaNueva.nombreMateria = Materias.HISTORIA;
				exito = true;
			}
			break;
		}
		}
	
		if (exito) {
			alumnoTemporal.listaMateria.add(materiaNueva);
			this.mapaAlumnos.put(alumnoTemporal.rut, alumnoTemporal);
			return exito;
		} else
			return exito;
	}




	public
	boolean agregarNotaPasoUno(Menu menu) {
		Alumno alumnoTemporal = new Alumno();
		boolean exito = false;
		Materia materiaNueva = new Materia();
		Utilidad.setCursor(40, 5);
		System.out.print("-------------------------------------------- Agregar Nota");
		Utilidad.setCursor(40, 6);
		System.out.print("RUT: ");
		Utilidad.setCursor(6 + 40, 6);
		String rut = menu.scanner.nextLine();
		alumnoTemporal = mapaAlumnos.get(rut);
	
		if (alumnoTemporal != null) {
			ArrayList<Integer> idMateriasDisponibles= new ArrayList<Integer>();
			if (poseeMateria(Materias.MATEMATICAS, alumnoTemporal)) {
				Utilidad.setCursor(40, 8);
				System.out.print("1. MATEMATICAS");
				idMateriasDisponibles.add(1);
			}
			if (poseeMateria(Materias.LENGUAJE, alumnoTemporal)) {
				Utilidad.setCursor(40, 9);
				System.out.print("2. LENGUAJE");
				idMateriasDisponibles.add(2);
			}
			if (poseeMateria(Materias.CIENCIAS, alumnoTemporal)) {
				Utilidad.setCursor(40, 10);
				System.out.print("3. CIENCIAS");
				idMateriasDisponibles.add(3);
			}
			if (poseeMateria(Materias.HISTORIA, alumnoTemporal)) {
				Utilidad.setCursor(40, 11);
				System.out.print("4. HISTORIA");
				idMateriasDisponibles.add(4);
			}
			if (alumnoTemporal.listaMateria.size() != 0) {
				Utilidad.setCursor(40, 12);
				System.out.print("Selecciona una Materia: ");
				Utilidad.setCursor(40, 13);
				System.out.print("Ingrese la Nota: ");
				Utilidad.setCursor(24 + 40, 12);
				int materiaSeleccionada = (int) MenuServicio.validarEntrada(menu.scanner.next());
				menu.scanner.nextLine();
				;
				if (idMateriasDisponibles.stream().noneMatch(id -> id == materiaSeleccionada)) return false;
				Utilidad.setCursor(24 + 40, 13);
				float nota = MenuServicio.validarEntrada(menu.scanner.next());
				menu.scanner.nextLine();
				switch (materiaSeleccionada) {
				case 1: {
					if (alumnoTemporal.listaMateria.stream().anyMatch(materia -> materia.nombreMateria.equals(Materias.MATEMATICAS))) {
					materiaNueva = alumnoTemporal.listaMateria.stream()
							.filter(materia -> materia.nombreMateria.equals(Materias.MATEMATICAS)).findFirst().get();
					}
					else {
						exito = false;
						return exito;
					}
					break;
				}
				case 2: {
					if (alumnoTemporal.listaMateria.stream().anyMatch(materia -> materia.nombreMateria.equals(Materias.LENGUAJE))) {
						materiaNueva = alumnoTemporal.listaMateria.stream()
								.filter(materia -> materia.nombreMateria.equals(Materias.LENGUAJE)).findFirst().get();
						}
						else {
							exito = false;
							return exito;
						}
					break;
				}
				case 3: {
					if (alumnoTemporal.listaMateria.stream().anyMatch(materia -> materia.nombreMateria.equals(Materias.CIENCIAS))) {
						materiaNueva = alumnoTemporal.listaMateria.stream()
								.filter(materia -> materia.nombreMateria.equals(Materias.CIENCIAS)).findFirst().get();
						}
						else {
							exito = false;
							return exito;
						}
					break;
				}
				case 4: {
					if (alumnoTemporal.listaMateria.stream().anyMatch(materia -> materia.nombreMateria.equals(Materias.HISTORIA))) {
						materiaNueva = alumnoTemporal.listaMateria.stream()
								.filter(materia -> materia.nombreMateria.equals(Materias.HISTORIA)).findFirst().get();
						}
						else {
							exito = false;
							return exito;
						}
					break;
				}
				default:{
					return false;
				}
				}
				if (nota > 0) {
				int indexOfMateriaAActualizar = alumnoTemporal.listaMateria.indexOf(materiaNueva);
				materiaNueva.notas.add(nota);
				materiaNueva.promedio = PromedioServicio.promedioServicioImp(materiaNueva.notas);
				alumnoTemporal.listaMateria.set(indexOfMateriaAActualizar, materiaNueva);
				mapaAlumnos.put(alumnoTemporal.rut, alumnoTemporal);
				exito = true;
				return exito;
				} else
				{
					return false;
				}
	
			} else {
				exito = false;
				return exito;
			}
	
		} else {
			exito = false;
			return exito;
		}
	
	}

public static ArrayList<Materia> materiasPorAlumno(AlumnosServicios alumnoServicio,String rut) {

	return alumnoServicio.mapaAlumnos.get(rut).listaMateria;

}
	
}

