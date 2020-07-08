package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import carrito.Carrito;
import easyprinter.So;
import excel.Excel;
import productos.Producto;

public class Menu {
  private static String codigo;
  private static int opcion;
  public ServicioDeCompras sirviente;



  public static void printMenu(ServicioDeCompras sirviente) {
    try {
    Scanner kinput = new Scanner(System.in);
    sirviente.listaDeProductos = Excel.leerLibroExcel();
    So.pf("1. Mostrar productos disponibles\n" + "2. Agregar producto al carrito\n" + "3. Pagar\n"
        + "4. Salir\n" + "Su opcion: ");
    opcion = kinput.nextInt();

    switch (opcion) {
      case 1: {
        printMostrarProductosDisponiblesMenu(sirviente);
        printMenu(sirviente);
        break;
      }
      case 2: {
        printAgregarACarritoMenu(sirviente);
        printMenu(sirviente);
        break;
      }
      case 3: {
        if(!sirviente.carrito.getProductosEnCarrito().isEmpty()) { //si no esta vacio
        printPagarMenu(sirviente);
        } else {
          So.pln("El carrito esta vacio, agregue algun producto primero...");
        }
        printMenu(sirviente);
        break;
      }
      case 4: {
        System.exit(0);
        break;
      }
      default: {
        printMenu(sirviente);
        break;
      }
    }
    } catch (Exception e) {
      
      printMenu(sirviente);
    }
  }


  private static void printPagarMenu(ServicioDeCompras sirviente) {
    try {
    Scanner kinput = new Scanner(System.in);
    So.pf("Cuál es su medio de pago?\n" + 
        "1- Credito\n" + 
        "2- Debito\n" + 
        "3- Cancelar\n"
        +"Su opcion:  \n");
    int opcion = kinput.nextInt();
    
    switch (opcion) {
      case 1:{
        printPagarConCreditoMenu(sirviente);
        break;
      }
      case 2:{
        printPagarConDebitoMenu(sirviente);
        break;
      }
      case 3:{
        printMenu(sirviente);
      }
      default:{
        printPagarMenu(sirviente);
      }
    }
      
    }catch (Exception e) {
      printPagarMenu(sirviente);
    }
    
  }


  private static void printPagarConCreditoMenu(ServicioDeCompras sirviente) {
    Scanner kinput = new Scanner(System.in);
    So.pf("¿Está seguro que desea pagar con crébito el total de $%.0f?\n" + 
          "Ingrese si (Y) o no (N)\n", sirviente.carrito.totalPrecioCompra);
    String opcion = kinput.next();
    if (opcion.equals("Y")||opcion.equals("y")) {
      metodoPagoCredito(sirviente);
     
      
    } else {
      So.pf("Pago Cancelado...%n%n");
    }
    
  }


  private static void metodoPagoCredito(ServicioDeCompras sirviente) {
    try {
      Scanner kinput = new Scanner(System.in);
      int cuotas;
    do {
    So.pln("¿Con cuantas cuotas desea pagar ? (0-24)");
    
    cuotas = kinput.nextInt();
    }while (cuotas > 24 || cuotas < 0);
  
    So.pf("¿Está seguro que desea pagar con %d cuotas?"
        + "\nIngrese Y para si o N para no\n", cuotas);
    String opcion2 = kinput.next();
    if (opcion2.equals("Y")||opcion2.equals("y")) {
      sirviente.cuotas = cuotas;
      generarDespachoPrompt(sirviente);
    } else {
      So.pln("Pago Cancelado, Volviendo al Menu..");
      printMenu(sirviente);
    }
    } catch (Exception e) {
      ;
      metodoPagoCredito(sirviente);
    }
    
    
  }


  private static void printPagarConDebitoMenu(ServicioDeCompras sirviente) {
    Scanner kinput = new Scanner(System.in);
    So.pf("¿Está seguro que desea pagar con débito el total de $%.0f?\n" + 
          "Ingrese si (Y) o no (N)\n", sirviente.carrito.totalPrecioCompra);
    String opcion = kinput.next();
    if (opcion.equals("Y")||opcion.equals("y")) {
      sirviente.cuotas = 0;
      generarDespachoPrompt(sirviente);
    } else {
      So.pf("Pago Cancelado...%n%n");
    }
  }


  private static void generarDespachoPrompt(ServicioDeCompras sirviente) {
    Scanner kinput = new Scanner(System.in);
    So.pf("Ingrese la direccion de despacho: ");
    String direccionDespacho = kinput.nextLine();
    So.pf("%nIngrese el nombre de quien recibe: ");
    String nombreDespacho = kinput.nextLine();
    So.pln("\n");
    Excel.generarDespacho(nombreDespacho, direccionDespacho, sirviente);
  }


  private static void printAgregarACarritoMenu(ServicioDeCompras sirviente) {
    try {
    sirviente.listaDeProductos = Excel.leerLibroExcel();
    Scanner kinput = new Scanner(System.in);
    So.pf("Ingrese el codigo del producto:%n");
    String codigo;
    codigo = kinput.nextLine();

    if (sirviente.listaDeProductos.stream()
        .anyMatch(producto -> producto.getCodigo().equals(codigo))) {
      ArrayList<Producto> encontrado = (ArrayList<Producto>) sirviente.listaDeProductos.stream()
          .filter(producto -> producto.getCodigo().equals(codigo)).collect(Collectors.toList());
      So.pf("¿Esta seguro que desea agregar el %s %s marca %s por $%.0f pesos?%nSi (Y) o No (N): %n", encontrado.get(0).getTipoDeProducto(), encontrado.get(0).getNombre(), encontrado.get(0).getMarca(), encontrado.get(0).getPrecio());
      String opcion = kinput.nextLine();
      if (opcion.equals("Y") || opcion.equals("y") ){
      sirviente.carrito.productosEnCarrito.addAll(0, encontrado);
      So.pf("%nSe ha añadido el %s %s marca %s al carrito de compras exitosamente%n%n",
          sirviente.carrito.getProductosEnCarrito().get(0).getTipoDeProducto(),
          sirviente.carrito.getProductosEnCarrito().get(0).getNombre(),
          sirviente.carrito.getProductosEnCarrito().get(0).getMarca());
      sirviente.carrito.totalPrecioCompra += sirviente.carrito.getProductosEnCarrito().get(0).getPrecio();
      } else {
        So.pf("El producto no se ingresó al carrito%n%n");
        }
    } else
      So.pf("No se encontró el producto%n");

    printMenu(sirviente); 
    } catch (Exception e) {
      
      ;
      printMenu(sirviente);
    }
  }


  private static void printMostrarProductosDisponiblesMenu(ServicioDeCompras sirviente) {
    sirviente.listaDeProductos = Excel.leerLibroExcel();
    sirviente.listaDeProductos.forEach(producto -> System.out.println(producto.toString()));

  }


}
