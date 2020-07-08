import java.util.InputMismatchException;
import java.util.Scanner;
public class SumaImparLimite{

	public static void main(String[] args) {
		Scanner kinput = new Scanner(System.in);
		try {
			int n = kinput.nextInt();
			if (n<0) {
				printError();
			}
			int n2 = kinput.nextInt();
			if (n2<n) printError();
			kinput.close();
			n2 = n2/2;
			int acumulador = 0;
			while (n<n2){
				System.out.println(2*(n+1)-1);
				acumulador += 2*(n+1)-1;
				n++;
			}
			System.out.println(acumulador);
		} catch (InputMismatchException e) {
			printError();
		}

	}

	private static void printError() {
		System.out.println("Error, n<0, n or n2=alphanumeric, or n2>n");
		System.exit(0);
	}

}