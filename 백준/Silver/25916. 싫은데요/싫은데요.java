import java.io.*;
import java.util.*;

public class Main {
	static int[] volumes;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		int size = Integer.parseInt(token.nextToken());
		int hamVolume = Integer.parseInt(token.nextToken());

		volumes = new int[size];
		token = new StringTokenizer(buffer.readLine());
		for (int i = 0; i < size; ++i) {
			int data = Integer.parseInt(token.nextToken());
			volumes[i] = data;
		}

		int en = 0;
		int total = 0;
		for (int st = 0; st < size; ++st) {
			while (en < size && total + volumes[en] <= hamVolume) {
				total += volumes[en];
				en++;
			}
			max = Math.max(max, total);
			total -= volumes[st];
		}

		System.out.println(max);
	}
}