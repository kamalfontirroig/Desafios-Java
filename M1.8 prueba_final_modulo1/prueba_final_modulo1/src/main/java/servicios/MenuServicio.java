package servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

import dominio.Alumno;
import utilidades.Utilidad;

public class MenuServicio {
	static int PaddingSuperiorImpresion = 5;
	private static int tabulacionInicial = 35;
	private static String espacio = "   ";
	private static int tabulacionMaterias = 15;

	public static void listarAlumnos(HashMap<String, Alumno> mapa) {

		int backUPPaddingSuperiorDeImpresion = PaddingSuperiorImpresion;
		ArrayList<Alumno> setAlumnos = new ArrayList<Alumno>(mapa.values());
		Collections.sort(setAlumnos, (o1, o2) -> o1.nombre.compareTo(o2.nombre));
		setAlumnos.forEach(alumno -> {

			Utilidad.setCursor(40, PaddingSuperiorImpresion++);
			String vacio = "";
			int n = tabulacionInicial - alumno.nombre.length() - alumno.rut.length();
			n = ((n > 0) ? n : 0);
			for (int j = 0; j < n; j++) {
				vacio += " ";
			}
			System.out.printf("%s %s   " + vacio + "|" + espacio, alumno.rut, alumno.nombre);

			Collections.sort(alumno.listaMateria, (o1, o2) -> o1.nombreMateria.compareTo(o2.nombreMateria));

			for (int z = 0; z < 4; z++) {
				if (alumno.listaMateria != null && z < alumno.listaMateria.size()) {
					Utilidad.setCursor(40 + tabulacionInicial + 3 + 2, PaddingSuperiorImpresion++ - 1);
					n = tabulacionMaterias - alumno.listaMateria.get(z).nombreMateria.name().length();
					vacio = "";
					for (int j = 0; j < n; j++) {
						vacio += " ";
					}

					System.out.printf("%s" + vacio + "%.1f", alumno.listaMateria.get(z).nombreMateria.name(),
							alumno.listaMateria.get(z).promedio);
					vacio = "";
				}

			}
		});

		PaddingSuperiorImpresion = backUPPaddingSuperiorDeImpresion;

	}

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

	public static float validarEntrada(String entrada) {
		if (isNumeric(entrada))
			return Float.parseFloat(entrada);
		else {
			return -1;
		}
	}

}
