package entradas;

import java.util.ArrayList;
import eventos.Evento;
import persona.Cliente;
import persona.Vendedor;

public class Entrada {

  static private ArrayList<Entrada> listaDeEntradas = new ArrayList<Entrada>();
  Evento evento;
  int precio;
  String asiento;
  Cliente cliente;
  Vendedor vendedor;
  boolean usada;
  

public Entrada() {};

public Entrada(Evento evento, Cliente cliente, String asiento, Vendedor vendedor) {
  if (cliente.permitirAccesoEdad(evento)) {
    this.asiento = asiento;
    this.evento = evento;
    this.cliente = cliente;
    this.vendedor = vendedor;
    this.usada = false;
    this.precio = evento.getPrecio();
    this.concretarVenta();
  } else System.out.println(cliente.getNombre() + " no tiene la edad suficiente para asistir al evento. La compra no se concretó%n%n");
}

public void concretarVenta() {
  if (cliente.permitirAccesoEdad(evento)) {
    listaDeEntradas.add(this);
    System.out.printf("Vendiendo entrada a cliente %s (%s) para evento %s%n%n", this.cliente.getNombre(), this.cliente.getRun(), this.evento.getNombre());
  }
}

public void usarEntrada() {
  if (!this.usada && this.evento.iniciado) {
    System.out.printf("Usando entrada con cliente %s (%s) para evento %s%nEntrada encontrada, %s puede pasar.%n%n",
                      this.cliente.getNombre(), this.cliente.getRun(), this.evento.getNombre(), this.cliente.getNombre());
    this.usada = true;
  } else if (!this.evento.iniciado){
    System.out.printf("Usando entrada con cliente %s (%s) para evento %s "
                    + "%nNo se puede usar la entrada porque el evento %s no está en curso%n%n",
                       this.cliente.getNombre(), this.cliente.getRun(), this.evento.getNombre(), this.evento.getNombre());
  } else {
    System.out.printf("Usando entrada con cliente %s (%s) para evento %s%n"
                    + "Entrada para rut %s ya fue usada, no puede pasar.%n%n", this.cliente.getNombre(), this.cliente.getRun(), this.evento.getNombre(), this.cliente.getRun());
  }
}

}
