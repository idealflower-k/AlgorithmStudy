import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;
	static int[][] invest;
	static int[][] profit;
	static int[] result;
	static int numCompanies;
	static int totalMoney;

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		totalMoney = Integer.parseInt(token.nextToken());
		numCompanies = Integer.parseInt(token.nextToken());

		dp = new int[numCompanies + 1][totalMoney + 1];
		invest = new int[numCompanies + 1][totalMoney + 1];
		profit = new int[numCompanies + 1][totalMoney + 1];
		result = new int[numCompanies + 1];

		for (int i = 1; i <= totalMoney; i++) {
			token = new StringTokenizer(buffer.readLine());
			int money = Integer.parseInt(token.nextToken());
			for (int j = 1; j <= numCompanies; j++) {
				profit[j][money] = Integer.parseInt(token.nextToken());
			}
		}

		dp();
		getResult();

		System.out.println(dp[numCompanies][totalMoney]);
		for (int i = 1; i <= numCompanies; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static void dp() {
		for (int i = 1; i <= numCompanies ; i++) {
			for (int j = 0; j <= totalMoney; j++) {
				for (int k = 0; k <= j; k++) {
					if (dp[i][j] < (dp[i - 1][j - k] + profit[i][k])) {
						dp[i][j] = dp[i - 1][j - k] + profit[i][k];
						invest[i][j] = k;
					}
				}
			}
		}
	}

	public static void getResult() {
		int moneyLeft = totalMoney;

		for (int i = numCompanies; i > 0; i--) {
			result[i] = invest[i][moneyLeft];
			moneyLeft -= result[i];
		}
	}
}
