package productos;

public class CuentaCorriente extends Producto {

  public CuentaCorriente(float saldo, float deuda, String numeroDeCuenta) {
    this.saldo = saldo;
    this.deuda = deuda;
    this.numeroDeCuenta = numeroDeCuenta;
  }

 public boolean abonar(float abono) {
   if (abono <= 0) {
     return false;
   } else {
    this.saldo += abono;
    return true;
   }
 }
 
 public boolean retirarDinero(float retiro) {
   if (retiro < 0 || this.saldo - retiro < 0) {
     return false;
   } else {
     this.saldo -= retiro;
     return true;
   }
 }
 
 
}
