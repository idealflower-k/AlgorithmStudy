import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		final char[] mobis = {'M', 'O', 'B', 'I', 'S'};
		final char[] no = {'N', 'O'};
		final char[] yes = {'Y', 'E', 'S'};

		String target = buffer.readLine();

		HashSet<Character> set = new HashSet<>();
		for (char aChar : target.toCharArray()) {
			set.add(aChar);
		}

		for (char mobi : mobis) {
			if (!set.contains(mobi)) {
				System.out.println(no);
				return;
			}
		}

		System.out.println(yes);
	}
}