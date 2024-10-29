import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());
		int result = 0;

		int height = Integer.parseInt(token.nextToken());
		int width = Integer.parseInt(token.nextToken());

		if (height == width) {
			result = 2 * (height - 1);
		} else if (height > width) {
			result = 2 * (width - 1) + 1;
		} else {
			result = 2 * (height - 1);
		}

		System.out.println(result);
	}
}