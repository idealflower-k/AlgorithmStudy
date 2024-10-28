import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());
		StringBuilder sb = new StringBuilder();

		int numTest = Integer.parseInt(token.nextToken());

		for (int i = 0; i < numTest; i++) {
			String num = buffer.readLine();
			int year = Integer.parseInt(num.substring(2));
			int nextYear = Integer.parseInt(num) + 1;
			if (nextYear % year == 0) {
				sb.append("Good\n");
			} else {
				sb.append("Bye\n");
			}
		}
		System.out.println(sb);
	}
}