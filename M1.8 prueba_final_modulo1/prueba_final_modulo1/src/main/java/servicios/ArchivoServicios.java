package servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

import dominio.Alumno;
import dominio.Materia;
import dominio.Materia.Materias;
import utilidades.PromedioServicio;
import vistas.Menu;

public class ArchivoServicios {
	
	static int PaddingSuperiorImpresion = 5;
	private static int tabulacionRutNombre = 30;
	private static String espacio = "   ";

	final static int rut = 0;
	final static int nombre = 1;
	final static int materia = 2;
	final static int nota = 3;
	static Scanner scanner = new Scanner(System.in);
	
	public HashMap<String,Alumno> cargarDatos(HashMap<String,Alumno> mapaAlumnosInicial) throws FileNotFoundException {
		// int i=0;
		BufferedReader buffReader = new BufferedReader(new FileReader(new File("").getAbsolutePath()+"\\paloblanco.txt"));
		AlumnosServicios datosAlumnos = new AlumnosServicios();
		if (mapaAlumnosInicial != null) {
			datosAlumnos.mapaAlumnos = mapaAlumnosInicial;
		}
		try {
			System.out.println("--------------------------------------------- ImportarDatos\r\n"
					+ "Ingresa la ruta en donde se encuentra el archivo a cargar \n"
					+ "ejemplo \"F:\\STARLORD\\prueba_mod_1\\notas.csv  ...");
			
			String rutaDelArchivoACargar = scanner.nextLine();
			if(rutaDelArchivoACargar.equals("esc")) {
				Menu.changeStatusExitoso(false);
				System.out.println(Menu.exitoso);
				return mapaAlumnosInicial;
			}
			try {
			buffReader = new BufferedReader(
					new FileReader(rutaDelArchivoACargar) );
			} catch (Exception e) {
				System.out.println("Ingreso una ruta invalida, intente de nuevo o escriba \"esc\" para volver al menu principal");
				rutaDelArchivoACargar = "";
				cargarDatos(mapaAlumnosInicial);
			}
			String temp;

			while ((temp = buffReader.readLine()) != null) {
				// i++;
				String[] datos = temp.split(",");
				// datos[nota] = datos[nota].substring(0, datos[nota].length() -1);
				// Si el alumno no está en el mapa de alumnos se crea al alumno y se ingresan
				// los datos correspondientes
				if (!datosAlumnos.mapaAlumnos.containsKey(datos[rut])) {
					Alumno alumnoTemporal = new Alumno();
					alumnoTemporal.rut = datos[rut];
					alumnoTemporal.nombre = datos[nombre];
					Materia materiaTemporal = new Materia();
					materiaTemporal.nombreMateria = Materias.valueOf(datos[materia]);
					materiaTemporal.notas.add(Float.parseFloat(datos[nota]));
					materiaTemporal.promedio = PromedioServicio.promedioServicioImp(materiaTemporal.notas);
					alumnoTemporal.listaMateria.add(materiaTemporal);
					datosAlumnos.mapaAlumnos.put(datos[rut], alumnoTemporal);
//					System.out.println(alumnoTemporal);
				} else {
					// Si esta el alumno y
					// Si la materia está ingresada en la lista de materias, se agrega la nota leida
					// a su lista de notas.
					if (datosAlumnos.mapaAlumnos.get(datos[rut]).listaMateria.stream()
							.anyMatch(mat -> mat.nombreMateria.equals(Materias.valueOf(datos[materia])))) {
						ArrayList<Materia> listaMateriaTemporal = datosAlumnos.mapaAlumnos
								.get(datos[rut]).listaMateria;
						Alumno alumnoTemporal = datosAlumnos.mapaAlumnos.get(datos[rut]);
						Materia materiaTemporal = listaMateriaTemporal.stream()
								.filter(mat -> mat.nombreMateria.equals(Materias.valueOf(datos[materia])))
								.collect(Collectors.toList()).get(0);
						listaMateriaTemporal.remove(materiaTemporal);
						materiaTemporal.notas.add(Float.parseFloat(datos[nota]));
						materiaTemporal.promedio = PromedioServicio.promedioServicioImp(materiaTemporal.notas);
						alumnoTemporal.listaMateria.add(materiaTemporal);
						datosAlumnos.mapaAlumnos.put(datos[rut], alumnoTemporal);
//						System.out.println(alumnoTemporal);
					} else {
						// sino, se crea la materia en el alumno y se agrega la nota
						Alumno alumnoTemporal = datosAlumnos.mapaAlumnos.get(datos[rut]);
						Materia materiaTemporal = new Materia();
						materiaTemporal.nombreMateria = Materias.valueOf(datos[materia]);
						materiaTemporal.notas.add(Float.parseFloat(datos[nota]));
						materiaTemporal.promedio = PromedioServicio.promedioServicioImp(materiaTemporal.notas);
						alumnoTemporal.listaMateria.add(materiaTemporal);
						datosAlumnos.mapaAlumnos.put(datos[rut], alumnoTemporal);
//						System.out.println(alumnoTemporal);
					}
					
					
				}
				

				}

				
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//	alumnosServicios.mapaAlumnos.values().forEach(System.out::println);
//	System.out.println(i);
		Menu.changeStatusExitoso(true);
		return datosAlumnos.mapaAlumnos;
	}

	public void exportarDatos(HashMap<String, Alumno> mapaAlumnos) {
		try {
			PrintWriter out = new PrintWriter("promedios.txt");
			mapaAlumnos.values().forEach(alumno -> {
				String linea="";
				for (Materia m: alumno.listaMateria) {
					linea = String.format("%s,%s,%s,%.1f", alumno.rut, alumno.nombre,m.nombreMateria, m.promedio) ;
					out.println(linea);
				}
				
			
			});
		out.close();
		Menu.changeStatusExitoso(true);
		} catch (FileNotFoundException e) {
			Menu.changeStatusExitoso(false);
			e.printStackTrace();
		}
		
	}
}
