package easyprinter;

import java.io.PrintStream;
import java.util.Locale;

/*
 * Esta clase abrevia el metodo System.out.print[f,ln,""]() a So.p[f,ln,""]()
 * So es el abreviado de System Out
 */
public class So {
  
  //Imprime con todos los posibles argumentos para metodo  system.out.print();
  public static void p(String str)
  {
    System.out.print(str);
  }

  public static void p(boolean str)
  {
    System.out.print(str);
  }

  public static void p(char str)
  {
    System.out.print(str);
  }

  public static void p(char[] str)
  {
    System.out.print(str);
  }

  public static void p(double str)
  {
    System.out.print(str);
  }

  public static void p(float str)
  {
    System.out.print(str);
  }

  public static void p(int str)
  {
    System.out.print(str);
  }

  public static void p(long str)
  {
    System.out.print(str);
  }

  public static void p(Object str)
  {
    System.out.print(str);
  }

  //metodo abreviado de system.out.println para todos los posibles types de argumentos
  public static void pln()
  {
    System.out.println();
  }
  public static void pln(String str)
  {
    System.out.println(str);
  }

  public static void pln(boolean str)
  {
    System.out.println(str);
  }

  public static void pln(char str)
  {
    System.out.println(str);
  }

  public static void pln(char[] str)
  {
    System.out.println(str);
  }

  public static void pln(double str)
  {
    System.out.println(str);
  }

  public static void pln(float str)
  {
    System.out.println(str);
  }

  public static void pln(int str)
  {
    System.out.println(str);
  }

  public static void pln(long str)
  {
    System.out.println(str);
  }

  public static void pln(Object str)
  {
    System.out.println(str);
  }

  //metodos abreviados para system.out.printf() con  todos los posibles tipos de argumentos
  public static PrintStream pf(String str, Object str2)
  {
    return System.out.printf(str,str2);
  }

  public static PrintStream pf(Locale str, String str2, Object str3)
  {
    return System.out.printf(str,str2,str3);
  }
 
  public static PrintStream pf(String str)
  {
    return System.out.printf(str);
  }
  public static PrintStream pf( String format, Object ... args)
  {
    return System.out.printf(format,args);
  }
}