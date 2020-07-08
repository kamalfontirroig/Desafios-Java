package biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.helpers.HSSFColumnShifter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import easyprinter.So;

class Excel {
  
  
  static ArrayList<Articulo> leerLibroExcel() {
    ArrayList<Articulo> articulos = new ArrayList<>();
    FileInputStream finput = null;
    Workbook libro = null;
    Sheet hoja = null;
    Row fila = null;
    String file = new File("").getAbsolutePath() + "\\src\\biblioteca\\ArticulosBiblioteca.xls";
    try {
      finput = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      So.pln("No se encontró el archivo " + file);
    }
    try {
      libro = WorkbookFactory.create(finput);
    } catch (EncryptedDocumentException e) {
      So.pln("No se puede leer el archivo " + file);
    } catch (IOException e) {
      So.pln("No se puede leer el archivo " + file);
    }

    hoja = libro.getSheetAt(0);
    int numeroFilas = hoja.getPhysicalNumberOfRows();
    Articulo articulo = null;
    for (int f = 0; f < numeroFilas; f++) {
      fila = hoja.getRow(f);
      if (fila.getCell(0) != null && fila.getCell(0).getStringCellValue() != null) {
        if (fila.getCell(0).getStringCellValue().equals("Libro")) {
          // Se crea un nuevo articulo libro con los valores de la fila del archivo
          articulo = new Libro(fila.getCell(1).getStringCellValue(),
              fila.getCell(2).getBooleanCellValue(), fila.getCell(3).getStringCellValue(),
              (int) fila.getCell(4).getNumericCellValue(), fila.getCell(5).getStringCellValue(),
              (int) fila.getCell(6).getNumericCellValue());
          // si no es un Libro, se crea una Pelicula con los valores de la fila del archivo
        } else {
          articulo = new Pelicula(fila.getCell(1).getStringCellValue(),
              fila.getCell(2).getBooleanCellValue(), fila.getCell(3).getStringCellValue(),
              (int) fila.getCell(4).getNumericCellValue(), fila.getCell(5).getStringCellValue(),
              (int) fila.getCell(6).getNumericCellValue());
        }
        // se agrega a la lista de articulos
        articulos.add(articulo);
      } else {
        break;
      }
    }
    try {
      finput.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      libro.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return articulos;
  }

  static void actualizarExcel(List<Articulo> articulos) {
  
    OutputStream foutput = null;
    HSSFWorkbook libro = new HSSFWorkbook(); 
    HSSFSheet hoja = null;
    HSSFRow fila = null;
    int cantidadDeArticulos = -1;

    hoja = libro.createSheet();
    cantidadDeArticulos = articulos.size();
    if (cantidadDeArticulos >=0) {
        for (int f = 0; f < cantidadDeArticulos; f++) {
          fila = hoja.createRow(f);
          if (articulos.get(f).getClass().equals(Libro.class)) {
            HSSFCell celda = fila.createCell(0);
            celda.setCellValue("Libro");
            HSSFCell celda4 = fila.createCell(4);
            celda4.setCellValue(((Libro) articulos.get(f)).getPaginas());
            HSSFCell celda5 = fila.createCell(5);
            celda5.setCellValue(((Libro)articulos.get(f)).getImprenta());
        } else {
          HSSFCell celda = fila.createCell(0);
          celda.setCellValue("Pelicula");
          HSSFCell celda4 = fila.createCell(4);
          celda4.setCellValue(((Pelicula) articulos.get(f)).getDuracion());
          HSSFCell celda5 = fila.createCell(5);
          celda5.setCellValue(((Pelicula)articulos.get(f)).getCalidad());
        }
          HSSFCell celda1 = fila.createCell(1);
          HSSFCell celda2 = fila.createCell(2);
          HSSFCell celda3 = fila.createCell(3);      
          HSSFCell celda6 = fila.createCell(6);     
          celda1.setCellValue(articulos.get(f).getNombre());
          celda2.setCellValue(articulos.get(f).isReservado());
          celda3.setCellValue(articulos.get(f).getCodigo());   
          celda6.setCellValue(articulos.get(f).getPlazo());
        }
    }
    
    //fin del if
    //escribir el libro al archivo
    String file = new File("").getAbsolutePath() + "\\src\\biblioteca\\ArticulosBiblioteca.xls";
    try {
      foutput = new FileOutputStream(file);
    } catch (FileNotFoundException e) {
      So.pln("No se encontró el archivo " + file);
    }
    try {
      libro.write(foutput);
    } catch (EncryptedDocumentException e) {
      So.pln("No se puede leer el archivo " + file);
    } catch (IOException e) {
      So.pln("No se puede leer el archivo " + file);
    }
    try {
      foutput.close();     
      libro.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
  
  static ArrayList<Logger> obtenerLogins() {
    ArrayList<Logger> loginsLista = new ArrayList<>();
    FileInputStream finput = null;
    Workbook libroLogins = null;
    Sheet hoja = null;
    Row fila = null;
    String file = new File("").getAbsolutePath() + "\\src\\biblioteca\\LoginsUsuarios.xls";
    try {
      finput = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      So.pln("No se encontró el archivo " + file);
    }
    try {
      libroLogins = WorkbookFactory.create(finput);
    } catch (EncryptedDocumentException e) {
      So.pln("No se puede leer el archivo " + file);
    } catch (IOException e) {
      So.pln("No se puede leer el archivo " + file);
    }

    hoja = libroLogins.getSheetAt(0);
    int numeroFilas = hoja.getPhysicalNumberOfRows();
    
    for (int f = 0; f < numeroFilas; f++) {
      fila = hoja.getRow(f);
      Logger login = new Logger();
      if (fila.getCell(0) != null && fila.getCell(0).getStringCellValue() != null) {
          login.setUser(fila.getCell(0).getStringCellValue());
          login.password =fila.getCell(1).getStringCellValue();
        loginsLista.add(login);
      } else {
        break;
      }
    }
    try {
      finput.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      libroLogins.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return loginsLista;
  }

}


