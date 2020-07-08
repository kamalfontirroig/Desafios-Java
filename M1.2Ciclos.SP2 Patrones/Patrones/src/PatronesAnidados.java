import java.util.InputMismatchException;
import java.util.Scanner;
public class PatronesAnidados {

	public static void main(String[] args) {
		Scanner kinput = new Scanner(System.in);
		try {
		
		int n = -1;
		while (n < 0) {
			n = kinput.nextInt();
			if (n < 0) System.out.printf("Error: Ingrese n>=0%nReingrese"); 
		}	
		kinput.close();
		patron1(n);
		patron2(n);
		patron3(n);
		patron4(n);
	}catch (InputMismatchException e) {
		System.out.printf("Error: ingreso un valor alfanumerico%nFIN");
		System.exit(0);
	}
	}
	
//	private static void printError() {
//		System.out.printf("Error: n<=0 or n=alfanumerico. Debe ingresar int n>0 %nFIN");
//		System.exit(0);
//	}
	
	private static void patron1(int n) {
		if (n==1) System.out.println("*"); 
		else {
			for (int i = 1; i<=n; i++) {
				if (i==1) { 
					for (int j = 0; j < n ; j++) System.out.print("*");
					System.out.println();
				}
				else if (i==n){ 
					for (int j = 0; j < n ; j++) System.out.print("*");
					System.out.println();
				} else for (int j = 0; j < n ; j++) {
						if (j==0) System.out.print("*");
						else if (j==(n-1)) System.out.println("*");
							else {
								System.out.print(" ");
							}
						}	
				
			}
		}	
		System.out.println();
	}
	
	private static void patron2(int n) {
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++) {
				if (i==1) {
					System.out.print("*");
					if (j==n) System.out.println();
				} else if (i==n) {
						System.out.print("*");
						if (j==n) System.out.println();
						} else if (j==(n-i+1)){ 
									System.out.print("*");
								} else {
									System.out.print(" ");
									if (j==n) System.out.println();
								}
				
			}
		System.out.println();
	}
	
	private static void patron3(int n) {
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				if (i==j) {
					System.out.print("x");
					if (j==n) System.out.println();
				} else if (j==(n-i+1)) {
					System.out.print("x");
					if (j==n) System.out.println();
				} else { 
					System.out.print(" ");
					if (j==n) System.out.println();
				}
		System.out.println();		
	}
	
	private static void patron4(int n) {
		for (int i = 1; i <=n; i++)
			for (int j = 1; j <=n; j++)
				if ((i!=1) && (j==1)) {
					System.out.print(" ");
				} else if ((i!=n) && (j==n)) {
					System.out.println(" ");
				} else {
					System.out.print("*");
					if (j==n) System.out.println();
				}
		System.out.println();
	}
	
}
