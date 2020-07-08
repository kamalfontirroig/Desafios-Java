import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Fibonacci{

	public static void main(String[] args) {
		Scanner kinput = new Scanner(System.in);
		try {
			int n = kinput.nextInt();
			kinput.close();
			if (n<0) {
				printError();
			}
			BigInteger acumulador1 = BigInteger.valueOf(0);
			BigInteger acumulador2 = BigInteger.valueOf(0);
			int i = 0;
			BigInteger fib = BigInteger.valueOf(0);
			if (n == 1) {
				System.out.printf("0%n1"); 
			} else {
				while (i<(n+1)){
					if (i == 1) {
						acumulador1 = BigInteger.valueOf(1);
						i++;
						fib = acumulador1;
						System.out.println(fib);
					}
					if (i == 2) {
						acumulador2 = BigInteger.valueOf(1);
						i++;
						fib = acumulador2; 
						System.out.println(fib);
					}else {			
						fib = acumulador1.add(acumulador2);
						System.out.println(fib); 
						acumulador1= acumulador2;
						acumulador2=fib;
						i++;
					}
				}
			}
			//System.out.println(acumulador);
		} catch (InputMismatchException e) {
			printError();
		}

	}

	private static void printError() {
		System.out.println("Error, n<0, n or n2=alphanumeric, or n2>n");
		System.exit(0);
	}

}