import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] count = new int[26];

		String str1 = br.readLine();
		String str2 = br.readLine();

		for (char c : str1.toCharArray()) {
			count[c - 'a']++;
		}
		for (char c : str2.toCharArray()) {
			count[c - 'a']--;
		}

		int result = 0;
		for (int i : count) {
			result += Math.abs(i);
		}
		System.out.println(result);
	}
}