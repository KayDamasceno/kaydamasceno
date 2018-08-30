import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Digite: p A B");
		Scanner sc = new Scanner(System.in);

		int p = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int parcial = 0;
		int contador = 0;

		for (int i = 0; i < p; i++) {
			parcial = (i*i*i + A*i + B)%p;
			for(int j = 0; j < p; j++) {
				if((j*j)%p == parcial) {
					System.out.println("("+i+","+j+")");
					contador++;
				}
			}
		}
		
		sc.close();
		System.out.println("Contém " +contador+" pontos + 1 ponto no infinito!");
	}

}
