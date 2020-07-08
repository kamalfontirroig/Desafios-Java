package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import biblioteca.Excel;
import easyprinter.So;
import menu.Menu;

public class Logger {
private String user;
String password;
ArrayList<Logger> loginLista;
public boolean permitirAcceso;

public Logger() {};

public boolean LogIn() {
  this.loginLista = Excel.obtenerLogins();
  Scanner kinput = new Scanner(System.in);
  this.permitirAcceso = false;
  So.pf("Usuario: ");
  this.setUser(kinput.nextLine());
  So.pf("%nClave: ");
  this.password = kinput.nextLine();
  this.loginLista.forEach(login -> {
    if (login.getUser().equals(this.getUser()) && login.password.equals(this.password)) {
      this.permitirAcceso = true;
    }
  });
  return this.permitirAcceso;
}
@Override
public
String toString() {
  return String.format(this.getUser() + "  " + this.password);
}

public String getUser() {
  return user;
}

public void setUser(String user) {
  this.user = user;
}
}


