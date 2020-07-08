import java.util.Scanner;
public class Resistencia {
	int[] resistencias = new int[3];
	float resultado;

	public static void main(String[] args) {
			Resistencia resistor = new Resistencia();
			resistor.promptResistencias(0);
			resistor.calcularResultado();
			resistor.mostarResultado();
	}

	private void mostarResultado() {
		System.out.printf("La resistencia total es de %.1f", this.resultado);		
	}

private void calcularResultado() {
		float r1 = (float) 1/this.resistencias[0];
		float r2 = (float) 1/this.resistencias[1];
		float r3 = (float) 1/this.resistencias[2];
		this.resultado = (float) 1/(r1 + r2 + r3);
	}	

	private void promptResistencias(int nresistencia) {
		Scanner kinput = new Scanner(System.in);
		try {
		
		for (int i= nresistencia ; i < 3; i++) {
			checker(kinput, i);
			nresistencia += 1;
		}
		} catch (java.util.InputMismatchException e) {
			System.out.printf("%nIngreso un valor alfanumerico%n"
							+ "Debe ingresar un numero entero mayor a '0'"
							+ "%n------------------------------------------%n%n");
			this.promptResistencias(nresistencia);
		}
		kinput.close();
	}

	private void checker(Scanner kinput, int i) {
		{
			
			System.out.print("Ingrese resistencia " + (i+1) + ": ");
			this.resistencias[i] = 0;
			while (this.resistencias[i] <= 0) {
				this.resistencias[i] = kinput.nextInt();
				System.out.println();
				if (this.resistencias[i] <= 0) {
					System.out.printf("Las resistencias deben ser numeros enteros %n"
									+ "mayores a '0'%n"
									+ "------------------------------------------%n%n"
									+ "Reingrese la resistencia " + (i+1) + ": ");
					
				}	
			}
		}
	}

}
