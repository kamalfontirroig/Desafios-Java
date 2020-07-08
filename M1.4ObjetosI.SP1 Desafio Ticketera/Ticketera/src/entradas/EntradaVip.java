package entradas;

import eventos.Evento;
import persona.Cliente;
import persona.Vendedor;

public class EntradaVip extends Entrada {
  private String nombreRegalo;
  private boolean regaloEntregado;
  
  public EntradaVip(Evento evento, Cliente cliente, String asiento, Vendedor vendedor, String nombreRegalo){
    super(evento, cliente, asiento, vendedor);
    this.regaloEntregado = false;
    this.nombreRegalo = nombreRegalo;
  }
}
