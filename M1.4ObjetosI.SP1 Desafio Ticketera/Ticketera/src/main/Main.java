package main;
import entradas.Entrada;
import eventos.Evento;
import persona.Cliente;
import persona.Persona;
import persona.Vendedor;

public class Main {
    
  public static void main(String[] args) {
    //Constructor Persona (String Nombre, int Edad, String FechaNacimiento, String Run)
    Cliente kamal = new Cliente("Kamal F.", 30, "06/11/1989", "17430249-9");
    Cliente sergio = new Cliente("Sergio V.", 30, "02/09/1956", "1532451-6");
    Cliente braulio = new Cliente("Braulio R.", 30, "05/10/1967", "2479122-9");
    Cliente bodoque = new Cliente("Bodoque C.", 30, "31/01/1979", "5124566-7");
    Cliente alexis = new Cliente("Alexis S.", 30, "28/02/1969", "3457339-2");
    Evento concierto = new Evento("Woodstock", 30 );
    Vendedor vendedor = new Vendedor("Juan", 50, "05/10/1976", "1655343-2");
 //   if (kamal.permitirAccesoEdad(concierto)) kamal.print();
    kamal = vendedor.venderEntrada(kamal, concierto, "D14");
    sergio = vendedor.venderEntrada(sergio,concierto, "D13");
    braulio = vendedor.venderEntrada(braulio,concierto, "D10");
    bodoque = vendedor.venderEntrada(bodoque,concierto, "D69");
    alexis = vendedor.venderEntradaVip(alexis,concierto, "PN420", "Consolador");
    
    kamal.usarEntrada();
    concierto.iniciarEvento();
    kamal.usarEntrada();
    kamal.usarEntrada();
    braulio.usarEntrada();
    sergio.usarEntrada();
    bodoque.usarEntrada();
    
    concierto.detenerEvento();
    alexis.usarEntrada();
    vendedor.reportarVentas();
    
  }
}
