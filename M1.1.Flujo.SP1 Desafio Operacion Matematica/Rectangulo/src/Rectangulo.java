import java.util.Scanner;

public class Rectangulo {
	int alto, ancho, area1, perimetro1;
	float x, area2, perimetro2, altox, anchox;
	
	
	public static void main(String args[]) {
		Rectangulo rect = new Rectangulo();
		rect.resolve();
		rect.checkPrint();
	}
	
	private void checkPrint() {
		if (!(this.altox <= 0 || this.anchox <= 0)) {
			print();
		} else {
			printError();
		}
	}

	private void printError() {
		System.out.printf("No se puede calcular la nueva area y perimetro%n"
						+ "FIN");		
	}

	private void print() {
		System.out.println("Area: " + this.area1  + "  " + "   Perimetro: " + this.perimetro1);
		System.out.printf("subArea: %.3f    subPerimetro: %.3f %nFIN", this.area2, this.perimetro2);
		
	}

	private void resolve() {
		this.area1 = this.alto * this.ancho;
		this.perimetro1 = this.alto * 2 + this.ancho * 2;
		this.anchox = (float) (ancho - 2*x);
		this.altox = (float) (alto - 2*x);
		this.area2 = this.altox * this.anchox;
		this.perimetro2 = 2*altox + 2*anchox;
	}

	private Rectangulo() {
		Scanner kinput = new Scanner(System.in);
		try {
			System.out.printf("Ingrese:  Alto Ancho X (int int float)%n");
			alto = kinput.nextInt();
			ancho = kinput.nextInt();
			x = kinput.nextFloat();
			kinput.close();
			
		} catch (java.util.InputMismatchException e) {
			System.out.printf("Algun dato ingresado no corresponde a su tipo %n"
							+ "Ingrese int int float (ej: 45 30 5,2)%nFIN");
			System.exit(0);
		}
	}


}
