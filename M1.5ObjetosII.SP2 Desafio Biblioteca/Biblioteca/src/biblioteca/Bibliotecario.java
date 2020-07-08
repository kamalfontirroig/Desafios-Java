package biblioteca;

import java.util.ArrayList;
import java.util.List;
import easyprinter.So;

public class Bibliotecario {

  private List<Articulo> articulos;
  private static Bibliotecario bibliotecario;

  private Bibliotecario() {}

  static public Bibliotecario invocarBibliotecario() {
    if (bibliotecario == null) {
      synchronized (Bibliotecario.class) {
        if (bibliotecario == null) {
          bibliotecario = new Bibliotecario();
        }
      }
    }
    So.pf("Se ha invocado al Bibliotecario Virtual%n%n------------------------------------------%n%n");
    return bibliotecario;
  }

  public void obtenerArticulos() {
    this.setArticulos(Excel.leerLibroExcel());
  }

  public void actualizarArticulos() {
    Excel.actualizarExcel(this.getArticulos());
  }

  public List<Articulo> buscarArticulo(String searchInput) {
    this.obtenerArticulos();
    ArrayList<Articulo> articulosEncontrados = new ArrayList<>();
    // this.getArticulos().forEach(articulo -> {
    // if (articulo.getNombre().contains(searchInput)
    // || articulo.getCodigo().contains(searchInput)) {
    // articulosEncontrados.add(articulo);
    for (int i = 0; i < this.getArticulos().size(); i++) {
      List<Articulo> articulos = this.getArticulos();
      if (this.getArticulos().get(i).getNombre().contains(searchInput)
          || this.getArticulos().get(i).getCodigo().contains(searchInput)) {
        articulosEncontrados.add((Articulo)(this.getArticulos().get(i)));
      }
    }
    return articulosEncontrados;
    
  }

  public List<Articulo> buscarArticuloParaReserva(String searchInput) {
    this.obtenerArticulos();
    ArrayList<Articulo> articulosEncontrados = new ArrayList<>();
    // this.getArticulos().forEach(articulo -> {
    // if (articulo.getNombre().contains(searchInput)
    // || articulo.getCodigo().contains(searchInput)) {
    // articulosEncontrados.add(articulo);
    for (int i = 0; i < this.getArticulos().size(); i++) {
      List<Articulo> articulos = this.getArticulos();
      if (this.getArticulos().get(i).getCodigo().equals(searchInput)) {
        articulosEncontrados.add((Articulo)(this.getArticulos().get(i)));
      }
    }
    return articulosEncontrados;
    
  }

  public List<Articulo> getArticulos() {
    return articulos;
  }

  public void setArticulos(List<Articulo> articulos) {
    this.articulos = articulos;
  }
  
  public void reservarArticulo(String codigo){
    List<Articulo> articulobuscado = this.buscarArticuloParaReserva(codigo);
    try {
        if (articulobuscado.size()!=0 && !articulobuscado.get(0).isReservado()) {
        synchronized (Bibliotecario.class) {
          this.obtenerArticulos();
        if (!this.buscarArticulo(codigo).get(0).isReservado()) {
          this.cambiarEstadoDelArticuloAReservado(articulobuscado.get(0));
          this.actualizarArticulos();
          System.out.printf("Se ha reservado el articulo \"%s\", codigo %s", articulobuscado.get(0).getNombre(), articulobuscado.get(0).getCodigo());
        } else So.pf("Error, articulo ya reservado%n%n");
        }
      }else if (articulobuscado.size()==0) So.pf("Error, codigo erroneo%n%n"); else So.pf("Error, articulo ya reservado%n%n");
    } catch (Exception e) {
     if (articulobuscado.size()==0) So.pf("Error, codigo erroneo%n%n"); else So.pf("Error, articulo ya reservado%n%n");
    }
    
  }
    
  private void cambiarEstadoDelArticuloAReservado(Articulo articulo) {
    synchronized (Bibliotecario.class) {
      this.obtenerArticulos();
      List<Articulo> articulosActualizados = new ArrayList<>();
      articulo.setReservado(true);
      this.getArticulos().forEach(ele -> {
        if (ele.getCodigo().equals(articulo.getCodigo())) {
          ele = articulo;
        }
        articulosActualizados.add(ele);
      });
      this.setArticulos(articulosActualizados);
      this.actualizarArticulos(); 
    }
  }
  
  public boolean devolverArticulo(String codigo) {
    try {
     Articulo articuloADevolver =this.buscarArticulo(codigo).get(0);
    if (articuloADevolver!=null && articuloADevolver.isReservado()) {
    this.cambiarEstadoDelArticuloADisponible(articuloADevolver);
    return true;
    } else { 
      So.pln("Error. El articulo ya se encontraba en Biblioteca");
      return false;
    }
    }catch (NullPointerException e ) {      
      So.pln("Ingreso un codigo invalido");
      return false;
    }
  }
    
  private void cambiarEstadoDelArticuloADisponible(Articulo articulo) {
    List<Articulo> articulosActualizados = new ArrayList<>();
    articulo.setReservado(false);
    this.obtenerArticulos();
    this.getArticulos().forEach(ele -> {
      if (ele.getCodigo().equals(articulo.getCodigo())) {
        ele = articulo;
      }
      articulosActualizados.add(ele);
    });
    this.setArticulos(articulosActualizados);
    this.actualizarArticulos();
  }


}
