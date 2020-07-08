package main;

import java.util.ArrayList;

public class Persona {
  String nombre;
  String correo;
  String ciudad;
  int monto;
  static public ArrayList<Persona> listaDePersonas;



  public Persona(String nombre, String correo, String ciudad, int monto) {
    this.nombre = nombre;
    this.correo = correo;
    this.ciudad = ciudad;
    this.monto = monto;
  }

public Persona() {
    // TODO Auto-generated constructor stub
  }

@Override
public String toString() {
  return String.format("nombre: %s%ncorreo: %s%nciudad: %s%nmonto: %d", this.nombre, this.correo, this.ciudad,this.monto);
}

public String getNombre() {
  return nombre;
}

public void setNombre(String nombre) {
  this.nombre = nombre;
}

public String getCorreo() {
  return correo;
}

public void setCorreo(String correo) {
  this.correo = correo;
}

public String getCiudad() {
  return ciudad;
}

public void setCiudad(String ciudad) {
  this.ciudad = ciudad;
}

public int getMonto() {
  return monto;
}

public void setMonto(int monto) {
  this.monto = monto;
}

public static ArrayList<Persona> getListaDePersonas() {
  return listaDePersonas;
}

public static void setListaDePersonas(ArrayList<Persona> listaDePersonas) {
  Persona.listaDePersonas = listaDePersonas;
}


}
