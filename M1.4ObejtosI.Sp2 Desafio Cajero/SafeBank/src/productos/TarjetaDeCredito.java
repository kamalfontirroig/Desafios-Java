package productos;

public class TarjetaDeCredito extends Producto {
  private float saldoMaximo;
  
  
public float getSaldoMaximo() {
    return saldoMaximo;
  }

public float setDeuda() {
  return this.deuda = (float) ((this.saldoMaximo - this.saldo)* 0.05); 
}

public TarjetaDeCredito() {
  
}
public TarjetaDeCredito(float saldoMaximo, String nmrCuenta, float saldo) {
  this.saldoMaximo = saldoMaximo;
  this.numeroDeCuenta = nmrCuenta;
  this.saldo = saldo;
  this.deuda = this.setDeuda();
}
  


}
