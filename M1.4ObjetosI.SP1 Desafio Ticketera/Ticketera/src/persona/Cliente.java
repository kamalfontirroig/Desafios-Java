package persona;

import entradas.Entrada;

public class Cliente extends Persona {

  Entrada entrada;
  
public Cliente(String nombre, int edadA�os, String fechanacimiento, String run) {
  super(nombre,edadA�os,fechanacimiento,run);
}

public void usarEntrada() {
  if (this.entrada != null) {
    this.entrada.usarEntrada();
  }
}

}
