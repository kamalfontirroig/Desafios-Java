import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Fechas {

	public static void main(String[] args) {
		try {
			DateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
			Scanner kinput = new Scanner(System.in);			
			System.out.println("Ingrese la primera fecha como DD/MM/AAAA");	
			String fecha1 = kinput.nextLine();
			Date date1 = ff.parse(fecha1);
			checkDate(fecha1);
			System.out.println("Ingrese la segunda fecha como DD/MM/AAAA");
			String fecha2 = kinput.nextLine();
			kinput.close();
			Date date2 = ff.parse(fecha2);
			checkDate(fecha2);
			compareDates(date1, date2);
		} catch (ParseException e) {
			printError();
		}
	}

	private static void compareDates(Date date1, Date date2) {
		if (date1.before(date2)) {
			System.out.println("La persona 1 es mayor");
		} else if (date1.equals(date2)) {
			System.out.println("Tienen la misma edad");
		} else System.out.println("La persona 2 es mayor");
	}
	
	private static void checkDate(String fecha) throws ParseException {
		int dia, mes/*,año*/;
		if (!(fecha.length()==10)) {
			printError();
		} else if (fecha.indexOf('/')!= 2 || fecha.indexOf('/',3) != 5 ){
					printError();
			   } else {
				   dia = Integer.parseInt(fecha.substring(0,2));
				   mes = Integer.parseInt(fecha.substring(3,5));
				// año = Integer.parseInt(fecha.substring(6,10));
				   if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
			   		   printError();
				   } else if (	   (mes == 2 && dia > 29) 
					   			|| (mes == 4 && dia > 30) 
					   			|| (mes == 6 && dia > 30) 
					   			|| (mes == 9 && dia > 30) 
					   			|| (mes == 11 && dia > 30) ) {
				   			printError();
			   		   	  }
			   	}
	}

	private static void printError() {
		System.out.printf("Ingreso Fecha invalida %nFIN");
		System.exit(0);
	}
		
}
