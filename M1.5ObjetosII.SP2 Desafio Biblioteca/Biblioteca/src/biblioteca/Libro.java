package biblioteca;

class Libro extends Articulo {

  int paginas;
  String imprenta;
  
  Libro(){};
  
  Libro(String nombre,  boolean reserva, String codigo, int paginas, String imprenta, int plazo ){
    super(nombre, reserva, codigo, plazo);
    this.paginas = paginas;
    this.imprenta = imprenta;
  }

  public int getPaginas() {
    return paginas;
  }

  public void setPaginas(int paginas) {
    this.paginas = paginas;
  }

  public String getImprenta() {
    return imprenta;
  }

  public void setImprenta(String imprenta) {
    this.imprenta = imprenta;
  }
  
  
  
}
