package persona;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import eventos.Evento;

public class Persona {

  String nombre;
  int edadAños;
  LocalDate fechaDeNacimiento;
  Period periodoEdad; 
  final DateTimeFormatter formatoDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
  String run;

  
   public Persona(){
  }
  
  public Persona(String nombre, int edadAños, String fechanacimiento, String run){
    this.fechaDeNacimiento = LocalDate.parse(fechanacimiento, formatoDeFecha);
    this.nombre = nombre;
    this.edadAños = edadAños;
    this.run = run;
    this.periodoEdad = Period.between(fechaDeNacimiento, LocalDate.now());
  }
  
  public void print() {
    System.out.printf("%s (RUN: %s) pasa%n",this.nombre, this.run );
  }
  
  public boolean permitirAccesoEdad(Evento evento){
    int comparador = this.comparaPeriodos(evento.getPeriodoDeIngreso());
    return  (comparador >=0)?true:false;
  }


  private int comparaPeriodos(Period periodoevento) {
  return period2Days(this.periodoEdad) - period2Days(periodoevento);
}

  private int period2Days(Period p) {
  if (p == null) {
      return 0;
  }
  int meses = p.getMonths();
  return (p.getYears() * 365 + meses * 31 + p.getDays() - ((meses==2)?2:0) - ((meses==4)?3:0) - ((meses==6)?4:0) - ((meses==11)?5:0) + p.getYears()/4);
}

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getRun() {
    return run;
  }

  public void setRun(String run) {
    this.run = run;
  }
  
  
}