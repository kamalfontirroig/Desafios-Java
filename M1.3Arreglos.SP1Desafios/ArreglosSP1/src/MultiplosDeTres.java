
public class MultiplosDeTres {
  static int cantidadDedatos;
  static int cantidadMultiplos3;
  static int sumaMultiplos3;
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    cantidadDedatos = args.length;
    cantidadMultiplos3 = 0;
    sumaMultiplos3 = 0;
    System.out.println("Ejercicio 3.");
    suma(filtro(args));
    System.out.println("Ejercicio 4.");
    promedio(filtro(args));
  }
    
  private static int[] filtro(String[] parametros) {
    int[] numerosint = new int[cantidadDedatos];
    for (int i = 0; i < cantidadDedatos; i++) {
      int entrada = Integer.parseInt(parametros[i]);
      numerosint[i] = (entrada%3==0)?entrada:0;
    }
    return numerosint;
  }
  private static void suma(int[] entrada){
    int acumulador = 0;
    for (int i = 0; i < cantidadDedatos; i++) {
    acumulador+= entrada[i];
    }
    System.out.printf("%d%n", acumulador);
    }
  
  private static void promedio(int[] parametros) {
    for (int i = 0; i < cantidadDedatos; i++) {
       cantidadMultiplos3 += (parametros[i]!=0)?1:0;
       sumaMultiplos3 += parametros[i];
    }
    System.out.printf("%.0f", (float) sumaMultiplos3/cantidadMultiplos3);
  }
}
