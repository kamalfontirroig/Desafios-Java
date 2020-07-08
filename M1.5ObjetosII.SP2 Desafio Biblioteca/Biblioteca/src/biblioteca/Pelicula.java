package biblioteca;

import biblioteca.Articulo;

class Pelicula extends Articulo {

  int duracion;
  String calidad;
  
  Pelicula(){};
  
  Pelicula(String nombre,  boolean reserva, String codigo, int duracion, String calidad, int plazo ){
    super(nombre, reserva, codigo, plazo);
    this.duracion = duracion;
    this.calidad = calidad;
    
    
  }

  public int getDuracion() {
    return duracion;
  }

  public void setDuracion(int duracion) {
    this.duracion = duracion;
  }

  public String getCalidad() {
    return calidad;
  }

  public void setCalidad(String calidad) {
    this.calidad = calidad;
  }
}
