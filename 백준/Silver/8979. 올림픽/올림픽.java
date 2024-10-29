import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		int numCountry = Integer.parseInt(token.nextToken());
		int target = Integer.parseInt(token.nextToken());

		double[] value = new double[numCountry + 1];

		for (int i = 0; i < numCountry; i++) {
			token = new StringTokenizer(buffer.readLine());
			int num = Integer.parseInt(token.nextToken());
			int gold = Integer.parseInt(token.nextToken());
			int silver = Integer.parseInt(token.nextToken());
			int iron = Integer.parseInt(token.nextToken());

			value[num] = (gold * 3) + (silver * 0.0000002) + (iron * 0.0000000000001);
		}

		double targetValue = value[target];
		int result = 1;
		for (int i = 1; i < numCountry; i++) {
			if (targetValue < value[i]) {
				result++;
			}
		}
		System.out.println(result);
	}
}