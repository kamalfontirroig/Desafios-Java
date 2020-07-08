package prueba_mod_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.mockito.Mockito.*;
import org.mockito.internal.configuration.injection.scanner.MockScanner;
import org.mockito.internal.util.collections.Sets;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;

import dominio.Alumno;
import dominio.Materia;
import dominio.Materia.Materias;
import servicios.AlumnosServicios;
import utilidades.PromedioServicio;
import vistas.Menu;

//Método crearAlumnoTest para verificar el funcionamiento de crearAlumno.
//Método agregarMateriaTest para verificar el funcionamiento de agregarMateria.
//Método materiasPorAlumnosTest, usando mock para verificar el funcionamiento de
//materiasPorAlumnos.
//Método listarAlumnosTest para verificar el funcionamiento de listarAlumnosTest.



@DisplayName("Testing Promedio")
class Tests {

private final AlumnosServicios alumnoServicio = new AlumnosServicios();
	@Test
	void promedioTest() {
		ArrayList<Float> notas = new ArrayList(Arrays.asList(4.3f,4.4f,3.7f,3.6f)); //promedio = 4.0f
		float promedioRespuesta = PromedioServicio.promedioServicioImp(notas);
		assertEquals(promedioRespuesta, 4.0);
	}

	
//	@Test 
	void crearAlumnoTest() {
//		Scanner scanner = new Scanner(System.in);
//		mockingSet.add("17430249-9");
//		mockingSet.add("Kamal Fontirroig");
//		mockingSet.add("Mi Casa");
//	
//		mockScanner.addPreparedMocks(mockingSet);
//	

		Alumno alumnoEsperado = new Alumno("17430249-9", "Kamal Fontirroig", "Mi Casa" );
		Alumno alumnoRespuesta = alumnoServicio.crearAlumno();

		assertEquals(alumnoRespuesta.rut, alumnoEsperado.rut);
		assertEquals(alumnoRespuesta.nombre, alumnoEsperado.nombre);
		assertEquals(alumnoRespuesta.direccion, alumnoEsperado.direccion);
		
	}



//@Test
void agregarMateriaTest() {
	Alumno alumno = new Alumno("17430249-9", "Kamal Fontirroig", "Mi Casa" );
	 alumnoServicio.crearAlumno(alumno);
	 Menu menu = new Menu();
	 boolean exito = alumnoServicio.agregarMateria(menu);
	 assertEquals(exito, true);
}


@Test
public void materiasPorAlumnoTest(){
	Alumno alumno = new Alumno("17430249-9", "Kamal Fontirroig", "Mi Casa" );
	 alumnoServicio.crearAlumno(alumno);
	 Materia materia = new Materia();
	 ArrayList<Materia> listaMateriasEsperada = new ArrayList<>();
	 materia.nombreMateria = Materias.CIENCIAS;
	 alumnoServicio.mapaAlumnos.get("17430249-9").listaMateria.add(materia);
	 listaMateriasEsperada.add(materia);
	 materia.nombreMateria = Materias.LENGUAJE;
	 alumnoServicio.mapaAlumnos.get("17430249-9").listaMateria.add(materia);
	 listaMateriasEsperada.add(materia);
	 materia.nombreMateria = Materias.MATEMATICAS;
	 alumnoServicio.mapaAlumnos.get("17430249-9").listaMateria.add(materia);
	 listaMateriasEsperada.add(materia);
	 materia.nombreMateria = Materias.HISTORIA;
	 alumnoServicio.mapaAlumnos.get("17430249-9").listaMateria.add(materia);
	 listaMateriasEsperada.add(materia);
	 
	 for (int i = 0; i< 4; i++){
	assertEquals(alumnoServicio.mapaAlumnos.get("17430249-9").listaMateria.get(i).nombreMateria, listaMateriasEsperada.get(i).nombreMateria);
	 }
}
}
////create a mock scanner
//Scanner mockScanner = mock(Scanner.class);
////set up the scanner
//when(mockScanner.nextLine()).thenReturn("add 5");
//
//InputOutput inputOutput= new InputOutput(mockScanner);
//
////assert output
//assertEquals("add 5", inputOutput.getInput());
//
////added bonus - you can verify that your scanner's nextline() method is
////actually called See Mockito.verify
//verify(mockScanner).nextLine();
//
//
//
//void MyTest {
//
//	  @Test
//	  public void shouldTakeUserInput() {
//	    systemInMock.provideLines("add 5", "another line");
//	    InputOutput inputOutput = new InputOutput();
//	    assertEquals("add 5", inputOutput.getInput());
//	  }