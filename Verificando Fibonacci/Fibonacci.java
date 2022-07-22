package verificandoFibonacci;

import java.util.Scanner;

/**
 * "VERIFICANDO NÚMERO FIBONACCI"
 * 
 * O código recebe um númeto int e verifica se esse número pertence à sequência
 * Fibonacci. Para isso é utilizado um vetor de 3 posições que guarda os dois
 * valores iniciais da sequência, e então é realizado o cálculo da sequência.
 * 
 * @author Renan Moreira
 *
 */
public class Fibonacci {
	static int numero_escolhido = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe o número a ser verificado: ");
		numero_escolhido = sc.nextInt();
		int[] fibonacci = new int[3]; // para realização do cálculo da sequência.
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		fibonacci[2] = 0;
		while (fibonacci[2] < numero_escolhido) {
			// a última posição recebe a soma das posições anteriores. As anteriores recebem
			// novos valores.
			fibonacci[2] = fibonacci[0] + fibonacci[1];
			fibonacci[0] = fibonacci[1];
			fibonacci[1] = fibonacci[2];
		}
		System.out.print("\nO número '" + numero_escolhido + "' " + VerificaNumero(fibonacci[2]));
	}

	/**
	 * Informa se o número alocado na 3ª posição do vetor pertence à sequência
	 * Fibonacci.
	 * 
	 * @param numero_na_sequencia - valor alocado na 3ª posição do vetor.
	 * @return
	 */
	public static String VerificaNumero(int numero_na_sequencia) {
		if (numero_na_sequencia == numero_escolhido) {
			return "PERTENCE à sequência Fibonacci.";
		} else {
			return "NÃO pertence à sequência Fibonacci.";
		}
	}

}
