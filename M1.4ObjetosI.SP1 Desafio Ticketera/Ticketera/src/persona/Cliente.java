package persona;

import entradas.Entrada;

public class Cliente extends Persona {

  Entrada entrada;
  
public Cliente(String nombre, int edadAños, String fechanacimiento, String run) {
  super(nombre,edadAños,fechanacimiento,run);
}

public void usarEntrada() {
  if (this.entrada != null) {
    this.entrada.usarEntrada();
  }
}

}
