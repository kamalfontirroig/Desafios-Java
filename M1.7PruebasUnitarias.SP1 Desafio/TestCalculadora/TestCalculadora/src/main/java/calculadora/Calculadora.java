package calculadora;

public class Calculadora {
  
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
  
  public Integer sumar(Integer a, Integer b) {
    if (a != null && b != null) {
      return a + b;
    } else {
      return 0;
    }
  }

  public Integer restar(Integer a, Integer b) {
    if (a != null && b != null) {
      return a - b;
    } else {
      return 0;
    }
  }

  public Integer multiplicar(Integer a, Integer b) {
    if (a != null && b != null) {
      return a * b;
    } else {
      return 0;
    }
  }


  public Integer dividir(Integer a, Integer b) {
    if (a != null && b != null) {
      if (b!=0)
      return a / b;
      else return null;
    } else {
      return null;
    }
  }
}

