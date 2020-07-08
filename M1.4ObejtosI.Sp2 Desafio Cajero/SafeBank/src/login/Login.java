package login;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import easyprinter.So;
import menu.Menu;
import productos.CuentaCorriente;
import productos.TarjetaDeCredito;

public class Login {

  private int run;
  private int clave;
  private String nombre;
  private int edad;
  private CuentaCorriente cta;
  private TarjetaDeCredito tC;
  static private Login usuario = new Login();
  static private ArrayList<Login> listaLogins = new ArrayList<Login>(Arrays.asList(
      new Login(10345255, 1034, "Juan", 24, new CuentaCorriente(5000, 15000, "00-10345255"),
          new TarjetaDeCredito(250000, "01-10345255", 300000)),
      new Login(17430249, 1743, "Kamal", 30, new CuentaCorriente(100000, 15000, "00-17430249"),
          new TarjetaDeCredito(750000, "01-17430249", 600000))));

  public void printLogin() {
    usuario = this;
    try {
     
      Scanner kinput = new Scanner(System.in);
      So.pf("Ingrese run sin dv, sin puntos ni guion%n");
      usuario.setRun(kinput.nextInt());
      So.pf("Ingrese su clave%n");
      usuario.setClave(kinput.nextInt());
      if (usuario.isLoginOk()) {
        usuario.obtenerUsuario();
        So.pf("%nAbriendo Menu%n%n");
        Menu.printMenu(usuario);
      } else {
        So.pf("%nrun o clave invalidos%n");
        printLogin();
      }
    } catch (Exception e) {
      So.pf("%nError, ingresó un valor alfanumerico,%n%n");
      printLogin();
    }
  }


  private void obtenerUsuario() {
    listaLogins.forEach(l -> {
      if (l.getRun() == this.getRun()) {
        usuario = l;
      } ;
    });
  }


  private boolean isLoginOk() {
    return listaLogins.stream()
        .anyMatch(l -> (this.getRun() == l.run) && (this.getClave() == l.clave)) ? true : false;
  }

  public int getRun() {
    return run;
  }

  public void setRun(int run) {
    this.run = run;
  }

  public int getClave() {
    return clave;
  }

  public void setClave(int clave) {
    this.clave = clave;
  }


  public String getNombre() {
    return nombre;
  }


  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public int getEdad() {
    return edad;
  }


  public void setEdad(int edad) {
    this.edad = edad;
  }


  public CuentaCorriente getCta() {
    return cta;
  }


  public void setCta(CuentaCorriente cta) {
    this.cta = cta;
  }



  public TarjetaDeCredito gettC() {
    return tC;
  }


  public void settC(TarjetaDeCredito tC) {
    this.tC = tC;
  }


  public Login() {

  }


  public Login(int run, int clave, String nombre, int edad, CuentaCorriente cuentaCorriente,
      TarjetaDeCredito tCredito) {
    super();
    this.run = run;
    this.clave = clave;
    this.nombre = nombre;
    this.edad = edad;
    this.cta = cuentaCorriente;
    this.tC = tCredito;

  }


  public Login(Login l) {
    this.nombre = l.nombre;
    this.run = l.run;
    this.edad = l.edad;
    this.clave = l.clave;
    this.cta = l.cta;
    this.tC = l.tC;

  }


}
