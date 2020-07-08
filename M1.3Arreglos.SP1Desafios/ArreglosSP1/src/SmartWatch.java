
public class SmartWatch {

  public static void main(String[] args) {
   
   System.out.println("Ejercicio 2.");
   System.out.printf( "El promedio de pasos es %.0f", promedioSteps(clearSteps(args)) );
  }

  private static float promedioSteps(int[] pasos) {
    int pasostotales = 0;
    int dias = 0;
    for (int i = 0; i < pasos.length; i++) {
     pasostotales+= pasos[i];
     if (pasos[i]!=0) {
       dias++;
     }
    }
    return (float) pasostotales/dias;
    
  }

  static int[] clearSteps(String [] pasosdiarios) {
    int[] pasosint = new int[pasosdiarios.length];

    for (int i = 0; i < pasosdiarios.length; i++) {
      pasosint[i] = Integer.parseInt(pasosdiarios[i]);
      if (pasosint[i] < 200 || pasosint[i] > 100000 ) {
        pasosint[i] = 0; 
    }
    }
    return pasosint;
  }
}
