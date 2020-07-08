package productos;

public class Producto {

  protected float saldo;
  protected float deuda;
  protected String numeroDeCuenta;
  
  public float getSaldo() {
    return saldo;
  }
  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }
  public float getDeuda() {
    return deuda;
  }
  public void setDeuda(float deuda) {
    this.deuda = deuda;
  }
  public String getNumeroDeCuenta() {
    return 
        numeroDeCuenta;
  }
  public void setNumeroDeCuenta(String numeroDeCuenta) {
    this.numeroDeCuenta = numeroDeCuenta;
  }
  
  public boolean pagarDeuda(float abono) {
    
    if ( abono < 0 || deuda - abono < 0) {
      return false;
    } else {
      this.deuda -= abono;
      return true;
    }
  }
 
  

}
