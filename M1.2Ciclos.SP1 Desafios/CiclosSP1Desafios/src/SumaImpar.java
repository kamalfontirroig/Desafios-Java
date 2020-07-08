import java.util.InputMismatchException;
import java.util.Scanner;
public class SumaImpar {

	public static void main(String[] args) {
		Scanner kinput = new Scanner(System.in);
		try {
			int n = kinput.nextInt();
			kinput.close();
			if (n<0) {
				printError();
			}
			int i = 1;
			n =	n/2;
			int acumulador = 0;
			while (i<(n+1)){
				//System.out.println(2*i-1);
				acumulador += 2*i-1;
				i++;
			}
			System.out.println(acumulador);
		} catch (InputMismatchException e) {
			printError();
		}

	}

	private static void printError() {
		System.out.println("Error, n<0 or n=alphanumeric");
		System.exit(0);
	}

}