import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/* 		ALUNO: KAYQUE DAMASCENO
 * 		CURSO: ENGENHARIA DA COMPUTAÇÃO
 * 		EMAIL: KAYQUEDAMASCENO18@GMAIL.COM
 * 		DATA: 08/09/2018
 * 
 * 
 */
public class FermatLittleTheorem {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite P: ");
		long p = sc.nextLong();

		long m = p -2;
		long tempoInicial, tempoFinal;
		long a = 0;
		long temp = 0;
		//Testando tempo de execução para os dois algoritmos
		System.out.println("Gerando valores para A...");
		System.out.println();
		System.out.println("Metodo 1 = Força Bruta");
		System.out.println("Metodo 2 = Fermat'sLittleTheorem");
		System.out.println();
		for(int i = 0; i < 10; i++) {
			
			a= ThreadLocalRandom.current().nextLong(p);
			System.out.println("Metodo 1: Teste " + (i+1) + " para a = "+a);
			tempoInicial = System.currentTimeMillis();
			temp = multiplicativoInverso(a, p);
			tempoFinal = System.currentTimeMillis();
			System.out.println("Tempo de execucao: " + (tempoFinal - tempoInicial)+ " ms " + " Inverso: "+temp);
			
			System.out.println("Metodo 2: Teste " + (i+1) + " para a = "+a);
			tempoInicial = System.currentTimeMillis();
			temp = FermatsLittleTheorem(a,m,p);
			tempoFinal = System.currentTimeMillis();
			System.out.println("Tempo de execucao: " + (tempoFinal - tempoInicial) +" ms " + " Inverso: "+temp);
			
			System.out.println();
		}
		 
		

		sc.close();

	}
	
	public static long FermatsLittleTheorem(long a, long m, long p) {
		long temp = 1;
		long atual = a;

		while (m > 0) {
			if (m % 2 == 1) {
				temp = temp * atual;
				if (temp > p)
					temp = temp % p;
			}
			atual = atual*atual;
			if (atual > p)
				atual = atual % p;
			m = m / 2;
		}
		return temp;
	}

	public static long multiplicativoInverso(long den, long p) {
		long inverso = 0;

		for (long i = 0; i < p; i++) {
			if ((i * den) % p == 1)
				inverso = i;
		}

		return inverso;
	}

}
