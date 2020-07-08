package main;

import menu.Menu;
import login.Login;

public class Main {

  public static void main(String[] args) {
    
    Menu menu = new Menu();
    Login login = new Login();
    login.printLogin();

  }

}
