import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class teste {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int p = Integer.parseInt(br.readLine());
		
		int aux = 0;
		int inverso = 0;
		int s2 = -5;
		for (int i = 0; i < p; i++) {
			if ((i + (-1)*s2) % p == 0)
				aux = i;
		}
		
		for (int i = 0; i < p; i++) {
			if ((i * aux) % p == 1)
				inverso = i;
		}
		System.out.println(aux);
		System.out.println(inverso);
	}

}
