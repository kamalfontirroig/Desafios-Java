package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {

  private static Persona tmp;

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    ArrayList<Persona> listaPersonas = (ArrayList<Persona>) loadCSV();
    //listaPersonas.forEach(persona -> System.out.println(persona.toString()));
    //(Persona encontrada = searchByName("Giselle Marshall", listaPersonas);
    //System.out.println(encontrada.toString());
    System.out.println("2)--------------------------------------------------------------------------------------------------");
    listaPersonas.stream().filter(persona -> persona.nombre.equals("Giselle Marshall")).forEach(persona -> System.out.println(persona));
    System.out.println();  
    System.out.println("4)--------------------------------------------------------------------------------------------------");
    listaPersonas.stream().filter(persona -> persona.correo.equals("imperdiet.non@enim.org")).forEach(persona -> System.out.println(persona));
    System.out.println();  
    System.out.println("5)--------------------------------------------------------------------------------------------------");
    HashSet ciudades = new HashSet(listaPersonas.stream().collect(Collectors.toList()));
    System.out.println(ciudades.size());
    System.out.println();  
    System.out.println("6)--------------------------------------------------------------------------------------------------");
    System.out.println(listaPersonas.stream().filter(persona -> persona.correo.contains("elit")).count());
    System.out.println();  
    System.out.println("7)--------------------------------------------------------------------------------------------------");
    listaPersonas.stream().map(persona -> persona.monto * 3).filter(monto-> monto > 29000).forEach(System.out::println); 
    System.out.println();  
    System.out.println("8)--------------------------------------------------------------------------------------------------");
    listaPersonas.stream().filter(persona -> persona.monto == (        (   listaPersonas.stream().map(p -> p.monto).min(Integer::compare).get()   )     )).forEach(System.out::println);
    System.out.println();  
    System.out.println("9)--------------------------------------------------------------------------------------------------");
    listaPersonas.stream().filter(persona -> persona.monto == (        (   listaPersonas.stream().map(p -> p.monto).max(Integer::compare).get()   )     )).forEach(System.out::println);
    System.out.println();  
    System.out.println("10)--------------------------------------------------------------------------------------------------");
    System.out.println((float)listaPersonas.stream().map(persona -> persona.monto).reduce( (p1,p2) -> p1+p2 ).get()/listaPersonas.size());
    System.out.println();  
    //System.out.println( listaPersonas.stream().max(Comparator.comparing(Persona::getMonto, (m1,m2) -> { return m1.compareTo(m2); }    )).get()  );

    }

  private static List<Persona> loadCSV() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("datos.csv"));
    return br.lines().map(line -> line.split(","))
        .map(values -> new Persona(values[0], values[1], values[2], Integer.parseInt(values[3])))
        .collect(Collectors.toList());
    
   
    }
  
  
  public static Persona searchByName(String name, ArrayList<Persona> listapersonas) {
   
    listapersonas.forEach(persona -> {
      if (persona.nombre.contentEquals(name)) {
        tmp = persona;
      }
    });
    return tmp;
  }

}
