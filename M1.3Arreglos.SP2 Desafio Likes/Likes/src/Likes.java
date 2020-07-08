import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class Likes implements Comparable<Likes> {
  
  String photoname;
  int likes;
  int cantidadobjetos;
  static int cantidadenlista = 0;
  static int totallikes = 0;
  
  public static void main(String[] args) {
    ArrayList<Likes> photolikeslist = new ArrayList<Likes>();
    ArrayList<String> rawdata = new ArrayList<>();
    String filepath = new String((new File("").getAbsolutePath())+ "\\src\\likes"); 
    showSortedPhotoLikesFromFile(photolikeslist, rawdata, filepath);
    showMayor(photolikeslist);
    showMenor(photolikeslist);
    showPromedio(photolikeslist);
    }

  private static void showPromedio(ArrayList<Likes> photolikeslist) {
    photolikeslist.forEach(ele -> { 
                                    totallikes += ele.likes;
    });
    System.out.printf("El promedio de like por foto es: %.0f", (float) totallikes/photolikeslist.size());
    
  }

  private static void showMenor(ArrayList<Likes> photolikeslist) {
    //Ordena de menor a  mayor la lista, entonces el primero de la lista sera el objeto Likes con menos likes
    Collections.sort(photolikeslist, new Comparator<Likes>(){
      @Override public int compare(Likes l1, Likes l2) {
        return l1.likes - l2.likes;
      }
    });
    int menor = photolikeslist.get(0).likes;    
    List<Likes> listamenores = photolikeslist.stream().filter(ele -> ele.likes == menor).collect(Collectors.toList());
    cantidadenlista = (int) listamenores.stream().count();
    int backup = cantidadenlista;
   
    if (cantidadenlista != 1) { //si hay mas de una foto con menos likes
      System.out.printf("Las fotos con menos likes son: ");
      listamenores.forEach( ele -> { 
                                      if (cantidadenlista-- != 1) {
                                        System.out.printf("%s, ", ele.photoname);                           
                                      } else {  
                                        System.out.printf("%s ", ele.photoname);
                                        cantidadenlista = backup; //reestablece el valor de cantidadenlista al original
                                      }
                                   }); 
      System.out.printf("con %d likes%n", listamenores.get(0).likes);

    } else {//si es solo una
              System.out.printf("La foto con menos likes es: %s con %d likes%n", listamenores.get(0).photoname, listamenores.get(0).likes);  
    }    
  }

  private static void showMayor(ArrayList<Likes> photolikeslist) {
    //Ordena de mayor a menor
    Collections.sort(photolikeslist, new Comparator<Likes>(){
      @Override public int compare(Likes l1, Likes l2) {
        return l2.likes - l1.likes;
      }
    });
    int mayor = photolikeslist.get(0).likes;    
    List<Likes> listamayores = photolikeslist.stream().filter(ele -> ele.likes == mayor).collect(Collectors.toList());
    cantidadenlista = (int) listamayores.stream().count();
    int backup = cantidadenlista;
    if (cantidadenlista != 1) { //si hay mas de una foto con maxlikes
      System.out.printf("Las fotos con mas likes son: ");
      listamayores.forEach( ele -> { 
                                      if (cantidadenlista-- != 1) {
                                        System.out.printf("%s, ", ele.photoname);                           
                                      } else {  
                                        System.out.printf("%s ", ele.photoname);
                                        cantidadenlista = backup; //reestablece el valor de cantidadenlista al original
                                      }
                                   }); 
      System.out.printf("con %d likes%n", listamayores.get(0).likes);

    } else {//si es solo una
              System.out.printf("La foto con mas likes es: %s con %d likes%n", listamayores.get(0).photoname, listamayores.get(0).likes);  
    }
  }

  private static void showSortedPhotoLikesFromFile(ArrayList<Likes> fotolikeslist, ArrayList<String> data,
      String path) {
    String temp;
    try {
      FileReader fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);

      try {
        while ((temp = br.readLine()) != null) {
          data.addAll( Arrays.asList(  temp.split(" ")  ) );
          while (data.remove(""));
        }
      } catch (IOException e) {
          printError();
      }
      
      do {
        Likes objtemp = new Likes();
        int contlikes = 0;
        temp = data.get(0);
        data.remove(temp);
        contlikes += 1;
        while (data.remove(temp)){
          contlikes +=1;
          } 
        objtemp.likes = contlikes;
        objtemp.photoname = temp;
        fotolikeslist.add(objtemp);
      } while (data.size()!=0);
      Collections.sort(fotolikeslist);
      printData(fotolikeslist);
    } catch (FileNotFoundException e) {
        printError();
    }
  }

  private static void printData(ArrayList<Likes> listadelikes) {
    listadelikes.forEach(fotolike -> System.out.printf("%5s: %d likes%n", fotolike.photoname, fotolike.likes));    
  }

  private static void printError() {
   System.out.printf("Error%nFIN");
   System.exit(0);    
  }

  @Override
  public int compareTo(Likes like) {
    int last = this.photoname.compareTo(like.photoname);
    return last;
  }

}
