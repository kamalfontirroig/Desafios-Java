import java.util.InputMismatchException;
import java.util.Scanner;
public class Patrones {
	static Scanner kinput = new Scanner(System.in);
	static int n;
	
	public static void main(String[] args) {
		printPatern();
	}

	private static void printPatern() {
		try {
			
			n = kinput.nextInt();
			
			if (!(n<=0)) { 
				kinput.close();
				patron1(n);
				System.out.println();
				patron2(n);
				System.out.println();
				patron3(n);
			} else printError();
		} catch (InputMismatchException e) {
			printError();
		}
	}

	private static void printError() {
		System.out.printf("Error: n<=0 or n=alfanumerico. Debe ingresar int n>0 %nFIN");
		System.exit(0);
	}
	
	static void patron1(int n) {
		for (int i = 1; i < (n+1); i++){
			if (i%2==1) {
				System.out.print("*");
			} else {
				System.out.print(".");
			}
		}
	}
	
	static void patron2(int n) {
		for (int i = 1; i < (n+1); i++){
			if (i%4!=0) System.out.print(i%4);
			else System.out.print(4);
		}
	}
	
	static void patron3(int n) {
		for (int i = 1; i < (n+1); i++){
			if (i%3!=0) {
				System.out.print("|");
			} else {
				System.out.print("*");
			}
		}
	}
}
