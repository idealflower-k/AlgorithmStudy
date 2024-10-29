import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		int numCompany = Integer.parseInt(token.nextToken());
		int numTarget = Integer.parseInt(token.nextToken());
		int[] moloco = new int[numCompany];
		int[] other = new int[numCompany];
		int[] diff = new int[numCompany];

		for (int i = 0; i < numCompany; i++) {
			token = new StringTokenizer(buffer.readLine());
			moloco[i] = Integer.parseInt(token.nextToken());
			other[i] = Integer.parseInt(token.nextToken());
			diff[i] = other[i] - moloco[i];
		}

		Arrays.sort(diff);

		int result = 0;
		int i = 0;
		for (int j = 0; j < numCompany && i < numTarget; j++) {
			if (diff[j] <= 0) {
				i++;
			} else {
				result = diff[j];
				i++;
			}
		}

		System.out.println(result);
	}
}