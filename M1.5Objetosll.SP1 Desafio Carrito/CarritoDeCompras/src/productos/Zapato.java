package productos;

public class Zapato extends Producto {

  private String modelo;

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  @Override
  public String toString() {
    return String.format("- %s [modelo=%s, talla=%.0f, marca=%s, precio=%.0f, nombre=%s, codigo=%s]",
        this.getTipoDeProducto(), this.getModelo(), this.getTalla(), this.getMarca(),
        this.getPrecio(), this.getNombre(), this.getCodigo());

  }
}
