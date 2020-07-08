package carrito;

import java.util.ArrayList;
import productos.Producto;

public class Carrito {
public ArrayList<Producto> productosEnCarrito;
public double totalPrecioCompra;

public ArrayList<Producto> getProductosEnCarrito() {
  return productosEnCarrito;
}

public void setProductosEnCarrito(ArrayList<Producto> productosEnCarrito) {
  this.productosEnCarrito.addAll(productosEnCarrito);
}
public void setProductosEnCarrito(Producto productosEnCarrito) {
  this.productosEnCarrito.add(productosEnCarrito);
}

}
