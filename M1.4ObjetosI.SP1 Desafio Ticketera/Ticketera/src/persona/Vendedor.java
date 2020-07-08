package persona;

import java.util.ArrayList;
import java.util.List;
import entradas.Entrada;
import entradas.EntradaVip;
import eventos.Evento;

public class Vendedor extends Persona {
  ArrayList<Entrada> entradasVendidas;
  int cantidadDeEntradasVendidas;
  int cantidadDeEntradasVipVendidas;
  
  public Vendedor(String nombre, int edadAños, String fechanacimiento, String run) {
    super(nombre,edadAños,fechanacimiento,run);
    this.entradasVendidas = new ArrayList<Entrada>();
    this.cantidadDeEntradasVendidas = 0;
  }
  
  public Cliente venderEntrada(Cliente cliente, Evento evento, String asiento) {
    if (cliente.permitirAccesoEdad(evento)) {
      this.cantidadDeEntradasVendidas += 1;
      cliente.entrada = new Entrada(evento, cliente, asiento, this);
      entradasVendidas.add(cliente.entrada);
      return cliente;
    } else return null;
  }
  
  public Cliente venderEntradaVip(Cliente cliente, Evento evento, String asiento, String nombreRegalo) {
    if (cliente.permitirAccesoEdad(evento)) {
      this.cantidadDeEntradasVipVendidas += 1;
      entradasVendidas.add(new EntradaVip(evento, cliente, asiento, this, nombreRegalo));
      cliente.entrada = new Entrada(evento, cliente, asiento, this);
      return cliente;
    } else return null;
  }
  
  public void reportarVentas(){
    System.out.printf("El vendedor %s ha vendido: %n%d entrada/s normal/es%n"
                    + "%d entrada/s VIP%n%n", this.getNombre(), this.cantidadDeEntradasVendidas,
                      this.cantidadDeEntradasVipVendidas);
    
  }
    
}
