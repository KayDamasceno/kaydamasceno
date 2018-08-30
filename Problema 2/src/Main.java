import java.io.IOException;
import java.util.Scanner;

public class Main {

	static int p;
	static int A, B;
	static int Px, Py;

	public static void main(String[] args) throws IOException {
		System.out.println("Digite: p A B Px Py");
		Scanner sc = new Scanner(System.in);
		
		p = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		Px = sc.nextInt();
		Py = sc.nextInt();

		int x = Px; // valor original
		int y = Py; // valor original
		int num, den; // s = num/den
		int s;
		int x2, y2; // Coordenadas da soma if P = Q
		int x3, y3; // Coordenadas da soma if P != Q
		do {

			if (x == Px && y == Py) {
				num = 3 * (x * x) + A;
				den = 2 * y;

				int mInverso = 0;
				int aInverso = 0;
				if (den > 0) {
					mInverso = multiplicativoInverso(den);
				} else {
					aInverso = aditivoInverso(den);
					mInverso = multiplicativoInverso(aInverso);
				}
				
				s = ((num % p) * (mInverso)) % p;

				x2 = (s * s - 2 * x) % p;

				if (x2 < 0)
					x2 = p + x2;

				y2 = (s * (x - x2) - y) % p;

				if (y2 < 0)
					y2 = p + y2;

				x = x2;
				y = y2;
				System.out.println("(" + x2 + "," + y2 + ")");
			} else {

				if (x == Px)
					break;

				num = y - Py;
				den = x - Px;

				int mInverso = 0;
				int aInverso = 0;

				if (den > 0) {
					mInverso = multiplicativoInverso(den);
				} else {
					aInverso = aditivoInverso(den);
					mInverso = multiplicativoInverso(aInverso);
				}
				s = ((num % p) * (mInverso)) % p;

				x3 = (s * s - (x + Px)) % p;
				if (x3 < 0)
					x3 = p + x3;

				y3 = (s * (x - x3) - y) % p;
				if (y3 < 0)
					y3 = p + y3;

				y = y3;
				x = x3;
				System.out.println("(" + x + "," + y + ")");
			}
		} while (x != Px || y != Py);

		sc.close();
	}

	public static int multiplicativoInverso(int den) {
		int inverso = 0;
		;
		for (int i = 0; i < p; i++) {
			if ((i * den) % p == 1)
				inverso = i;
		}

		return inverso;
	}

	public static int aditivoInverso(int den) {
		int aux = 0;
		for (int i = 0; i < p; i++) {
			if ((i + (-1) * den) % p == 0)
				aux = i;
		}
		return aux;

	}
}
