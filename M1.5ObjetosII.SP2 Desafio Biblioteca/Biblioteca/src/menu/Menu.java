package menu;

import java.util.List;
import java.util.Scanner;
import biblioteca.Articulo;
import biblioteca.Bibliotecario;
import easyprinter.So;

public class Menu {

  public Bibliotecario señorSmith = Bibliotecario.invocarBibliotecario();

  public Menu() {};

  public void printMenu() {

    Scanner kinput = new Scanner(System.in);
    So.pf(
        "%nBienvenido a la Biblioteca%n--------------------------%n¿Qué desea hacer?%n%n"
        + "1- Reservar un articulo%n"
        + "2- Buscar articulo%n"
        + "3- Devolver articulo%n"
        + "4- Ver lista de articulos disponibles%n"
        + "0- Salir%n"
        + "--------------------------%n%n");
    So.p("Su opcion: ");
    int entry = 0;
    try {
      entry = Integer.parseInt(kinput.nextLine());


      if (entry == 1) {
        try {
          So.pf("Ingrese el codigo del articulo que desea reservar: ");
          this.reservar(kinput.nextLine());
          So.pln();
          printMenu();
        } catch (Exception e) {
          this.printError();
          this.printMenu();
        }
      }

      if (entry == 2) {
        So.pf("Ingrese su busqueda: ");
        So.pln();
        List<Articulo> busqueda = señorSmith.buscarArticulo(kinput.nextLine());
        if (busqueda.size() == 0) {
          So.pln("Sin resultados");
        } else {
          So.pln("Resultados: ");
          busqueda.forEach(articulo -> So.p(articulo.toString()));
        }
        printMenu();
      }

      if (entry == 0) {
        So.pln("Salir...");
        System.exit(0);
      }

      if (entry == 3) {
        So.pln("Ingrese el codigo del articulo que devuelve");
        String codigo = kinput.nextLine();
        señorSmith.devolverArticulo(codigo);
      }
      
      if (entry == 4) {
        señorSmith.obtenerArticulos();
        So.pln("\nLos siguientes articulos se encuentran disponibles:\n");
        señorSmith.getArticulos().stream().filter(articulo -> !articulo.isReservado()).forEach(So::pln);
        So.pln("--------------------------------------------------------------------------------------------------------\n\n");
      }
      printMenu();

    } catch (Exception e) {
      So.pln("Ingreso un valor alfanumerico, debe ingresar una de las 3 opciones...");
      So.pln("---------------------------------------------------------------------");
      this.printMenu();
    }
  }

  private void printError() {
    So.pln("Error, menu reiniciado");
  }

  private void reservar(String codigo) {
    señorSmith.reservarArticulo(codigo);
  }

}
