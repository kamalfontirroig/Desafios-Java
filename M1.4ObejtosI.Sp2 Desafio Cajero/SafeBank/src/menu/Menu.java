package menu;

import java.text.ParseException;
import java.util.Scanner;
import easyprinter.So;
import login.Ejecutivo;
import login.Login;
import productos.CuentaCorriente;

public class Menu {

  private static Scanner kinput = new Scanner(System.in);
  private static int opcion;
  private static Login usuario;

  public static void printMenu(Login user) {
    opcion = 0;
    usuario = user;
    try {
      So.pf(
          "Bienvenido %s (%d Años)%n" + "Qué deseas hacer ?%n" + "1- Menu Cuenta Corriente%n"
              + "2- Menu Tarjeta de Credito%n" + "3- Ver datos de mi ejecutivo%n" + "4- Salir%n",
          usuario.getNombre(), usuario.getEdad());
      try {
      opcion = Integer.parseInt(kinput.nextLine());
      }catch (Exception e) {
        printMenu(usuario);
      }
      switch (opcion) {
        case 1: {
          printCtaCorrienteMenu(usuario);
          break;
        }
        case 2: {
          printTCreditoMenu();
          break;
        }
        case 3: {
          printDatosEjecutivoMenu();
          break;
        }
        case 4: {
          So.pf("Cerrando el programa, adios");
          System.exit(0);
          break;
        }
        default:{
          printMenu(usuario);
        }
      }

    } catch (Exception e) {
      So.pf("Error Fatal: " + e + "...%n ...Reiniciando Menu...%n%n-----------------------------------------%n%n");
      Login login = new Login();
      login.printLogin();
  
    }
  }

  private static void printDatosEjecutivoMenu() {
    Ejecutivo ejecutivo = new Ejecutivo("Juan Tapia", "+56 69420 420 69", "Av. Porno Sonic 69, Oficina 420");
    So.pln(ejecutivo.toString());
    printMenu(usuario);
  }

  private static void printTCreditoMenu() {

    So.pf("Tarjeta de credito: %s%n" 
        + "Saldo actual: %.1f / %.1f%n"
        + "La deuda de su tarjeta de credito es: %.1f%n" 
        + "Qué desea hacer ?%n"
        + "1. Volver al menu%n" 
        + "2. Pagar mi deuda%n",
        usuario.gettC().getNumeroDeCuenta(),
        usuario.gettC().getSaldo(),
        usuario.gettC().getSaldoMaximo(),
        usuario.gettC().getDeuda());
    opcion = kinput.nextInt();
    
    switch (opcion) {
      case 1: {
        printMenu(usuario);
      }
      case 2: {
        if (usuario.gettC().getDeuda()==0) {
          So.pln("Ud. no tiene deuda%n%n");
          printTCreditoMenu();
        }
        So.pf("Desea abonar (1) o pagar la totalidad (2)%n");
        if ((opcion = kinput.nextInt())==1) 
        {
          So.pf("Ingrese cuanto desea pagar:%n");
        if (usuario.gettC().pagarDeuda(kinput.nextInt())) {
          So.pf("Deuda abonada exitosamente%n%n");
        } else {
          So.pf("Error, la deuda no se pagó%n");
        }
        } else {
          if (opcion == 2) usuario.gettC().pagarDeuda(usuario.gettC().getDeuda());
          So.pf("Deuda pagada en su totalidad exitosamente%n%n");
          printTCreditoMenu();
        }
        printTCreditoMenu();
      }
      default: {
        printTCreditoMenu();
      }
    }
  }

  private static void printCtaCorrienteMenu(Login user) {
    So.pf(
        "Cuenta Corriente: %s%n" + "Saldo actual: %.0f%n" + "La deuda de su cuenta es: %.0f%n"
            + "Qué desea hacer ?%n" + "1. Volver al menu%n" + "2. Depositar dinero%n"
            + "3. Retirar dinero%n" + "4. Pagar mi deuda%n",
        user.getCta().getNumeroDeCuenta(), user.getCta().getSaldo(), user.getCta().getDeuda());
    opcion = kinput.nextInt();
    switch (opcion) {
      case 1: {
        printMenu(usuario);
        break;
      }
      case 2: {
        So.pln("Ingrese cuanto desea depositar");
        int abono = kinput.nextInt();
        if (usuario.getCta().abonar(abono))
          So.pln("Deposito Exitoso");
        else
          So.pln("Error en el deposito, no se realizó");
        printCtaCorrienteMenu(usuario);
        break;
      }
      case 3: {
        So.pln("Ingrese cuanto desea retirar");
        int egreso = kinput.nextInt();
        if (usuario.getCta().retirarDinero(egreso))
          So.pln("Retiro Exitoso");
        else
          So.pln("Error en el Retiro de dinero, no se realizó");
        printCtaCorrienteMenu(usuario);
        break;
      }
      case 4: {
        if (usuario.gettC().getDeuda()==0) {
          So.pln("Ud. no tiene deuda%n%n");
          printCtaCorrienteMenu(usuario);
        }
        So.pln("Ingrese cuanto desea abonar a su deuda");
        int abono = kinput.nextInt();
        if (usuario.getCta().pagarDeuda(abono))
          So.pln("Pago Exitoso");
        else
          So.pln("Error en el Pago de su Deuda, no se realizó");
        printCtaCorrienteMenu(usuario);
        break;
      }
      default: {
        printCtaCorrienteMenu(usuario);
      }
    }

  }

}
