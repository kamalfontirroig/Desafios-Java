package productos;

public class Pantalon extends Producto {

    private String color;
    private double bolsillos;
    
    public double getBolsillos() {
      return bolsillos;
    }
    public void setBolsillos(double bolsillos) {
      this.bolsillos = bolsillos;
    }
    public String getColor() {
      return color;
    }
    public void setColor(String color) {
      this.color = color;
    }
    
    @Override
    public String toString() {
      return String.format("- %s [color=%s, bolsillos=%.0f, talla=%.0f, marca=%s, precio=%.01f, nombre=%s, codigo=%s]",
          this.getTipoDeProducto(), this.getColor(), this.getBolsillos(), this.getTalla(), this.getMarca(),
          this.getPrecio(), this.getNombre(), this.getCodigo());

    }
}
