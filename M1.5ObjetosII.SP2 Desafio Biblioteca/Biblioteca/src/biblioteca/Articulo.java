package biblioteca;

import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.*;

public abstract class Articulo {

  private String nombre;
  private boolean reservado;
  private String codigo;
  private int plazo;
  private static ArrayList<Articulo> listaDeArticulos;

  Articulo() {};

  Articulo(String nombre, boolean reserva, String codigo, int plazo) {
    this.nombre = nombre;
    this.reservado = reserva;
    this.codigo = codigo;
    this.plazo = plazo;

  }

  void crearListaDeArticulos(HSSFWorkbook libroExcel) {

  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public boolean isReservado() {
    return reservado;
  }

  public void setReservado(boolean reservado) {
    this.reservado = reservado;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public static ArrayList<Articulo> getArticulos() {
    return listaDeArticulos;
  }

  public static void setArticulos(ArrayList<Articulo> listaDeArticulos) {
    Articulo.listaDeArticulos = listaDeArticulos;
  }


  public int getPlazo() {
    return plazo;
  }

  public void setPlazo(int plazo) {
    this.plazo = plazo;
  }

  interface Articular {
    int getDuracion();

    String getCalidad();

    int getPaginas();

    String getImprenta();

  }

  @Override
  public String toString() {
    String salida;
    if (this.getClass().equals(Libro.class)) {
      salida = String.format(
          "Libro [\"%s\", %d paginas, Editorial %s, %d dias de plazo, codigo: %s, Estado: %s]%n%n",
          this.nombre, ((Libro) this).paginas, ((Libro) this).imprenta, this.plazo, this.codigo,
          (this.reservado) ? "Reservado" : "Disponible");
    } else {
      salida = String.format(
          "Pelicula [%s, %d minutos de duracion , Resolucion: %s, %d dias de plazo, codigo: %s, Estado: %s]%n%n",
          this.nombre, ((Pelicula) this).duracion / 60, ((Pelicula) this).calidad, this.plazo,
          this.codigo, (this.reservado) ? "Reservado" : "Disponible");
    }
    return salida;
  }
}
