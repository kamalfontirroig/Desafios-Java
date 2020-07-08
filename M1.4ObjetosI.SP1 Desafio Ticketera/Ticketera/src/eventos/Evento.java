package eventos;

import entradas.Entrada;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Evento {


  protected String nombre;
  protected int edadMinimaA�os;
  protected Period periodoComparacionParaIngreso;
  protected ArrayList<Entrada> entradasLista;
  final DateTimeFormatter formatoDeFecha = DateTimeFormatter.ofPattern("dd/mm/yyyy"); 
  protected int precio;
  public boolean iniciado;
  
  
  public Evento() {
    
  }
  
  public Evento (String nombre, int edadMinimaA�os) {
    this.nombre = nombre;
    this.edadMinimaA�os = edadMinimaA�os;
    this.periodoComparacionParaIngreso = Period.ofYears(edadMinimaA�os);
    this.entradasLista = new ArrayList<Entrada>();
    this.iniciado = false;
    System.out.printf("Creando evento %s (Edad minima: %d a�os)%n%n", this.nombre, this.edadMinimaA�os);
  }
  
  public void iniciarEvento() {
    this.iniciado = true;
    System.out.printf("Evento %s ha iniciado%n%n", this.getNombre());
  }
  
  public void detenerEvento() {
    this.iniciado = false;
    System.out.printf("Evento %s se ha detenido%n%n", this.getNombre());
  }
  
  public Period getPeriodoDeIngreso() {
    return periodoComparacionParaIngreso;
  }
  public void setPeriodoComparacionParaIngreso(Period periodoComparacionParaIngreso) {
    this.periodoComparacionParaIngreso = periodoComparacionParaIngreso;
  }

  public int getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) {
    if (precio>=0) this.precio = precio;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}


