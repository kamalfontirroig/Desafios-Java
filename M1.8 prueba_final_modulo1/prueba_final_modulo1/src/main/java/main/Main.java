package main;

import java.io.IOException;

import utilidades.Utilidad;
import vistas.Menu;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.FColor;

public class Main {

	
	/* 							IMPORTANTE 	IMPORTANTE 	IMPORTANTE 
	 * 
	 * El programa debe correr por consola de windows (CMD.EXE) para que funcione apropiadamente
	 * Esto es por el metodo borrarPantalla() que solo funciona en CMD.EXE y no en la consola de Eclipse
	 * 
	 * Para correr el programa, desde CMD.EXE situarse en la carpeta raiz y utilizar el siguiente comando:
	 * 
	 *  				mvn exec:java -Dexec.mainClass="main.Main"
	 *  
	 *  Debe estar instalado maven en la maquina...
	 */
	public static void main(String[] args) {
		Utilidad.borrarPantalla();
		Menu menu = new Menu();
		menu.printMenuPrincipal("Bienvenido", null, FColor.CYAN);
		menu.cargarDatos();

	}

}
