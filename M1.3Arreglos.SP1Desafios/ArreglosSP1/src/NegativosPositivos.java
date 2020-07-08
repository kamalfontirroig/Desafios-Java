
public class NegativosPositivos {
  int positivos;
  int negativos;
  int ceros;  
  
  public static void main(String[] args) {
    NegativosPositivos contador = new NegativosPositivos();
    System.out.println("Ejercicio 5.");
    contador.contar(args).imprimir();
  }

  NegativosPositivos(){
    this.positivos=0;
    this.negativos=0;
    this.ceros=0;
  }
  
  private NegativosPositivos contar(String[] args) {
    for (int i = 0; i < args.length; i++) {
      int entrada = Integer.parseInt(args[i]);
      this.positivos += (entrada > 0)?1:0;
      this.negativos += (entrada < 0)?1:0;
      this.ceros += (entrada == 0)?1:0;
    }
    return this;
  }
  private void  imprimir() {

    System.out.println(this.positivos);
    System.out.println(this.ceros);
    System.out.println(this.negativos);
  }

}
