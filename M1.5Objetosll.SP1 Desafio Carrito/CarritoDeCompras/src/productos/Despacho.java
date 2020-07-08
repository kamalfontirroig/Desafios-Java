package productos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Despacho {
  
   public String direccionDeDespacho;
   public String nombreDelCliente;
   public String codigosProductos;
   public double montoTotal;
   public LocalDate fechaDeCompra;
   public double cuotas;
   
   public Despacho() {}
   
   public Despacho(String direccion, String nombre, String codigos, double monto, LocalDate fecha){
     this.direccionDeDespacho =direccion;
     this.nombreDelCliente = nombre;
     this.codigosProductos = codigos;
     this.montoTotal = monto;
     this.fechaDeCompra = fecha;
   }
}
