
public class Visitas {
  int acumulador = 0;
  float promedio;
  
  public static void main(String[] args) {
  Visitas promediov = new Visitas();
  promediov.promedio(args);
  System.out.println("Ejercicio 1.");
  System.out.printf("El resultado es %.0f", promediov.promedio);
  }
  
  void promedio(String[] visitas) {
  for (int i = 0; i < visitas.length; i++) {
    this.acumulador+= Integer.parseInt(visitas[i]);
  }
  this.promedio = (float) this.acumulador/visitas.length;

 }
}



