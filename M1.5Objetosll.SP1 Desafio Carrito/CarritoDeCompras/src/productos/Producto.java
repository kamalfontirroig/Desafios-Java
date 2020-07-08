package productos;

public class Producto {
  
  private String tipoDeProducto;
  private double precio;
  private String nombre;
  private double talla;
  private String codigo;
  private String marca;
  
  public String getTipoDeProducto() {
    return tipoDeProducto;
  }
  public void setTipoDeProducto(String tipoDeProducto) {
    this.tipoDeProducto = tipoDeProducto;
  }
  public double getPrecio() {
    return precio;
  }
  
  public void setPrecio(double d) {
    this.precio = d;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public double getTalla() {
    return talla;
  }
  public void setTalla(double d) {
    this.talla = d;
  }
  public String getMarca() {
    return marca;
  }
  public void setMarca(String marca) {
    this.marca = marca;
  }
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  
  
}
