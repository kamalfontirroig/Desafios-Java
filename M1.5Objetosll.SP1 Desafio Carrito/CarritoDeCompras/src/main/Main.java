package main;

import java.time.LocalDate;
import java.util.ArrayList;
import carrito.Carrito;
import easyprinter.So;
import menu.Menu;
import menu.ServicioDeCompras;
import productos.Producto;


public class Main {

  public static void main(String[] args) {
    
    LocalDate date = LocalDate.now();
    So.pln(date.toString());
    ServicioDeCompras sirviente = new ServicioDeCompras();
    sirviente.carrito = new Carrito();
    sirviente.carrito.productosEnCarrito = new ArrayList<Producto>();
    Menu.printMenu(sirviente);
  }

}
