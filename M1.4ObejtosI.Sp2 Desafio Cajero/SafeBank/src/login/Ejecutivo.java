package login;

public class Ejecutivo {
  private String nombre;
  private String telefono;
  private String direccion;
  
  @Override
  public String toString() {
    return String.format("- - - - - - - -%n"
        + "Datos de tu ejecutivo:%n"
        + "Nombre: %s, Telefono: %s, Direccion: %s%n"
        + "- - - - - - - -%n"
        + "... Volviendo al menú principal%n",this.nombre, this.telefono, this.direccion);
  }
  
  public Ejecutivo(String n, String t, String d) {
    this.direccion = d;
    this.nombre = n;
    this.telefono = t;
  }
}
