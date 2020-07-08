package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import carrito.Carrito;
import easyprinter.So;
import menu.ServicioDeCompras;
import productos.Despacho;
import productos.Pantalon;
import productos.Poleron;
import productos.Producto;
import productos.Zapato;

public class Excel {

  static private String codigos = "";
  static private Row filaCrear;
  static private int i = 0;

  public static ArrayList<Producto> leerLibroExcel() {
    ArrayList<Producto> productos = new ArrayList<>();
    FileInputStream finput = null;
    Workbook libro = null;
    Sheet hoja = null;
    Row fila = null;
    String file = new File("").getAbsolutePath() + "\\productos.xls";
    try {
      finput = new FileInputStream(file);
    } catch (FileNotFoundException e) {
      ;
      So.pln("No se encontró el archivo " + file);
    }
    try {
      libro = WorkbookFactory.create(finput);
    } catch (EncryptedDocumentException e) {
      ;
      So.pln("No se puede leer el archivo " + file);
    } catch (IOException e) {
      ;
      So.pln("No se puede leer el archivo " + file);
    }

    hoja = libro.getSheetAt(0);
    int numeroFilas = hoja.getPhysicalNumberOfRows();
    for (int f = 0; f < numeroFilas; f++) {
      fila = hoja.getRow(f);
      Zapato zapato;
      Poleron poleron;
      Pantalon pantalon;
      if (fila.getCell(0) != null && fila.getCell(0).getStringCellValue() != null) {
        if (fila.getCell(0).getStringCellValue() == "Zapato") {
          zapato = new Zapato();
          zapato.setTipoDeProducto(fila.getCell(0).getStringCellValue());
          zapato.setPrecio(fila.getCell(1).getNumericCellValue());
          zapato.setNombre(fila.getCell(2).getStringCellValue());
          zapato.setCodigo(fila.getCell(3).getStringCellValue());
          zapato.setTalla(fila.getCell(4).getNumericCellValue());
          zapato.setMarca(fila.getCell(5).getStringCellValue());
          zapato.setModelo(fila.getCell(6).getStringCellValue());
          productos.add(zapato);
        } else if (fila.getCell(0).getStringCellValue() == "Pantalon") {
          pantalon = new Pantalon();
          pantalon.setTipoDeProducto(fila.getCell(0).getStringCellValue());
          pantalon.setPrecio(fila.getCell(1).getNumericCellValue());
          pantalon.setNombre(fila.getCell(2).getStringCellValue());
          pantalon.setCodigo(fila.getCell(3).getStringCellValue());
          pantalon.setTalla(fila.getCell(4).getNumericCellValue());
          pantalon.setMarca(fila.getCell(5).getStringCellValue());
          pantalon.setColor(fila.getCell(7).getStringCellValue());
          pantalon.setBolsillos(fila.getCell(8).getNumericCellValue());
          productos.add(pantalon);
        } else {
          poleron = new Poleron();
          poleron.setTipoDeProducto(fila.getCell(0).getStringCellValue());
          poleron.setPrecio(fila.getCell(1).getNumericCellValue());
          poleron.setNombre(fila.getCell(2).getStringCellValue());
          poleron.setCodigo(fila.getCell(3).getStringCellValue());
          poleron.setTalla(fila.getCell(4).getNumericCellValue());
          poleron.setMarca(fila.getCell(5).getStringCellValue());
          poleron.setColor(fila.getCell(7).getStringCellValue());
          productos.add(poleron);
        }
      }
    }
    try {
      finput.close();
    } catch (IOException e) {
      ;
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      libro.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return productos;
  }

  public static void generarDespacho(String nombreDespacho, String direccionDespacho,
      ServicioDeCompras sirviente) {
    ArrayList<Despacho> despachosLista = new ArrayList<>();
    Workbook libro = null;
    try {
      String file = new File("").getAbsolutePath() + "\\despachos.xls";
      FileInputStream finput = new FileInputStream(file);
      libro = WorkbookFactory.create(finput);
    } catch (EncryptedDocumentException e) {
      ;
      So.pln("No se puede leer el archivo ");
    } catch (IOException e) {
      ;
      So.pln("No se puede leer el archivo ");
    }

    Sheet hoja = libro.getSheet("despachos");
    Row fila = null;
    int numeroFilas = hoja.getPhysicalNumberOfRows();
    for (int f = 0; f < numeroFilas; f++) {

      fila = hoja.getRow(f);
      if (fila.getCell(0) != null) {
        try {
          despachosLista.add(leerFilaDeDespacho(fila));
        } catch (ParseException e) {
          So.pf("parcing error%n");
          e.printStackTrace();
        }
      }

      sirviente.carrito.getProductosEnCarrito().forEach(producto -> {
        codigos += producto.getCodigo() + ",";
      });
    }
    sirviente.despacho = new Despacho();
    sirviente.despacho.nombreDelCliente = nombreDespacho;
    sirviente.despacho.direccionDeDespacho = direccionDespacho;
    sirviente.despacho.codigosProductos = codigos;
    sirviente.despacho.fechaDeCompra = LocalDate.now();
    sirviente.despacho.montoTotal = sirviente.carrito.totalPrecioCompra;
    Despacho aDespachar = new Despacho(sirviente.despacho.nombreDelCliente,
        sirviente.despacho.direccionDeDespacho, sirviente.despacho.codigosProductos,
        sirviente.despacho.montoTotal, sirviente.despacho.fechaDeCompra);
    aDespachar.cuotas = sirviente.cuotas;
    despachosLista.add(aDespachar);
    // ahora debe escribir el excel
    HSSFWorkbook libroNuevo = new HSSFWorkbook();
    Sheet hojas = libroNuevo.createSheet("despachos");
    
   
    despachosLista.forEach(despacho ->{
      
    filaCrear = hojas.createRow(i);
    filaCrear.createCell(0).setCellValue( despacho.nombreDelCliente);
    filaCrear.createCell(1).setCellValue( despacho.direccionDeDespacho);
    filaCrear.createCell(2).setCellValue( despacho.codigosProductos);
    filaCrear.createCell(3).setCellValue( despacho.montoTotal);
    filaCrear.createCell(4).setCellValue( despacho.fechaDeCompra.toString());
    filaCrear.createCell(5).setCellValue(despacho.cuotas);
    i++;
    });
    i=0;
    try {
      String file = new File("").getAbsolutePath() + "\\despachos.xls";
      FileOutputStream foutput = new FileOutputStream(file);
      libroNuevo.write(foutput);
      foutput.close();
      libroNuevo.close();
      So.pln("Orden de despacho generada correctamente, volviendo al Menu...\n\n");
      So.pln("El Carrito ahora esta vacio");
      sirviente.carrito.productosEnCarrito= new ArrayList<Producto>();
    } catch (EncryptedDocumentException e) {
      So.pln("No se puede leer el archivo ");
    } catch (IOException e) {
      So.pln("No se puede leer el archivo ");
    } catch (Exception e) {
      ;
      So.pln("Hubo un Error al crear el archivo despachos");
    }
   
    


  }// fin metodo

  private static Despacho leerFilaDeDespacho(Row fila) throws ParseException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    Despacho despacho = new Despacho();
    despacho.nombreDelCliente = fila.getCell(0).getStringCellValue();
    despacho.direccionDeDespacho = fila.getCell(1).getStringCellValue();
    despacho.codigosProductos = fila.getCell(2).getStringCellValue();
    despacho.montoTotal = fila.getCell(3).getNumericCellValue();
    despacho.fechaDeCompra = LocalDate.parse(fila.getCell(4).getStringCellValue(), formatter);
    despacho.cuotas = fila.getCell(5).getNumericCellValue();
    return despacho;
  }


}


