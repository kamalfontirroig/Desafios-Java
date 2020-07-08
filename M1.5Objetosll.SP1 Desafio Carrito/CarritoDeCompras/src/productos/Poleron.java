package productos;

public class Poleron extends Producto {
private String color;

public String getColor() {
  return color;
}

public void setColor(String color) {
  this.color = color;
}

@Override
public String toString() {
  return String.format("- %s [color=%s, talla=%.0f, marca=%s, precio=%.0f, nombre=%s, codigo=%s]",
      this.getTipoDeProducto(), this.getColor(), this.getTalla(), this.getMarca(),
      this.getPrecio(), this.getNombre(), this.getCodigo());

}
}
