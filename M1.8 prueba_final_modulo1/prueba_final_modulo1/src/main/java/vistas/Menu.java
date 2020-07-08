package vistas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.FColor;

import dominio.Alumno;
import servicios.AlumnosServicios;
import servicios.ArchivoServicios;
import servicios.MenuServicio;
import utilidades.Utilidad;

public class Menu extends MenuTemplate {
	static public boolean exitoso = false;

	public enum TipoMenu {
		LISTA_ALUMNO, CREAR_ALUMNO, AGREGAR_MATERIA, AGREGAR_NOTA
	}

	public static AlumnosServicios alumnoServicio = new AlumnosServicios();
	static ArchivoServicios archivoServicio = new ArchivoServicios();
	private Object exito;

	// SobreCarga para dar color al mensaje opcional
	public void printMenuPrincipal(String mensajeOpcional, TipoMenu tipoDeMenu, FColor color) {
		Utilidad.borrarPantalla();

		if (tipoDeMenu == TipoMenu.LISTA_ALUMNO)
			listarAlumnos(alumnoServicio.mapaAlumnos);
		mainMenuPrinter(); // imprime el cuerpo del menu
		if (tipoDeMenu == TipoMenu.CREAR_ALUMNO) {
			Alumno alumnoTemp = alumnoServicio.crearAlumno();
			alumnoServicio.mapaAlumnos.put(alumnoTemp.rut, alumnoTemp);
		}

		if (tipoDeMenu == TipoMenu.AGREGAR_MATERIA) {
			if (alumnoServicio.agregarMateria(this)) {
				mensajeOpcional = "Materia Agregada Exitosamente";
			} else {
				mensajeOpcional = "Error Materia No agregada";
				color = FColor.RED;
			}
		}
		if (tipoDeMenu == TipoMenu.AGREGAR_NOTA) {
			if (agregarNotaPasoUno()) {
				mensajeOpcional = "Nota Agregada Exitosamente";
			} else {
				mensajeOpcional = "Error Nota no agregada";
				color = FColor.RED;
			}
		}
		Utilidad.setCursor(8, 3);
		ColoredPrinter gP = new ColoredPrinter.Builder(1, false).foreground(color).build();
		gP.print(mensajeOpcional);
		Utilidad.setCursor(17, 12);
		opcion = (int) MenuServicio.validarEntrada(scanner.next());
		scanner.nextLine();
		switch (opcion) {
		case 1: {
			printMenuPrincipal("Alumno Nuevo Creado", TipoMenu.CREAR_ALUMNO, FColor.MAGENTA);
			break;
		}
		case 2: {

			printMenuPrincipal("Lista de Alumnos", TipoMenu.LISTA_ALUMNO, FColor.BLUE);
			break;
		}
		case 3: {
			printMenuPrincipal("", TipoMenu.AGREGAR_MATERIA, FColor.GREEN);
			break;
		}
		case 4: {
			printMenuPrincipal("", TipoMenu.AGREGAR_NOTA, FColor.GREEN);
			break;
		}
		case 5: {
			cargarDatos();
			printMenuPrincipal((exitoso) ? "Datos Cargados" : "Datos no cargados", null,
					(exitoso) ? FColor.GREEN : FColor.RED);
			break;
		}
		case 6: {
			exportarDatos();
			printMenuPrincipal(exitoso ? "Datos Exportados" : "Error Datos no Exportados", null,
					exitoso ? FColor.GREEN : FColor.RED);
			break;
		}
		case 7: {
			terminarPrograma();
			break;
		}
		default: {
			printOpcionInvalida();
			printMenuPrincipal("Opcion invalida", null, FColor.RED);
			break;
		}
		}
	}

	private void mainMenuPrinter() {
		Utilidad.setCursor(5, 5);
		System.out.println("1. Crear Alumnos");
		Utilidad.setCursor(5, 6);
		System.out.println("2. Listar Alumnos");
		Utilidad.setCursor(5, 7);
		System.out.println("3. Agregar Materias");
		Utilidad.setCursor(5, 8);
		System.out.println("4. Agregar Notas");
		Utilidad.setCursor(5, 9);
		System.out.println("5. Cargar Datos");
		Utilidad.setCursor(5, 10);
		System.out.println("6. Exportar Datos");
		Utilidad.setCursor(5, 11);
		System.out.println("7. Salir");
		Utilidad.setCursor(5, 12);
		System.out.println("Selección: ");
	}

	@Override
	public boolean cargarDatos() {
		try {
			alumnoServicio.mapaAlumnos = archivoServicio.cargarDatos(alumnoServicio.mapaAlumnos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	void exportarDatos() {
		archivoServicio.exportarDatos(alumnoServicio.mapaAlumnos);

	}

	/**
	 * @deprecated Use
	 *             {@link servicios.AlumnosServicios#agregarNotaPasoUno(vistas.Menu)}
	 *             instead
	 */
	@Override
	boolean agregarNotaPasoUno() {
		return alumnoServicio.agregarNotaPasoUno(this);
	}

//	/**
//	 * @deprecated Use {@link servicios.AlumnosServicios#agregarMateria(vistas.Menu)} instead
//	 */
//	@Override
//	boolean agregarMateria() {
//		return alumnoServicio.agregarMateria(this);
//	}

	@Override
	void listarAlumnos(HashMap<String, Alumno> mapa) {
		MenuServicio.listarAlumnos(mapa);

	}

	private void printOpcionInvalida() {
		System.out.println("...Ingresó una opción invalida...");
	}

	public static void changeStatusExitoso(boolean b) {
		exitoso = b;
	}
}
