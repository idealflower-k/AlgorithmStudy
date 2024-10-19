import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long S = (long) N * (N + 1) / 2;

		if (S % 2 != 0) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		S /= 2;
		long[] dp = new long[(int)S + 1];
		dp[0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = (int)S; j >= i; j--) {
				dp[j] += dp[j - i];
			}
		}

		bw.write(Long.toString(dp[(int)S] / 2));
		bw.newLine();
		bw.flush();
		bw.close();
		br.close();
	}
}