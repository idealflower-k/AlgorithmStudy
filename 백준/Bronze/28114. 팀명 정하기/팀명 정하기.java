import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		String[][] teams = new String[3][3];

		for (int i = 0; i < 3; i++) {
			token = new StringTokenizer(buffer.readLine());
			teams[i][0] = token.nextToken();
			teams[i][1] = token.nextToken();
			teams[i][2] = token.nextToken();
		}

		System.out.println(solve1(teams));
		System.out.println(solve2(teams));

	}

	public static String solve1(String[][] teams) {
		int[] order = new int[3];
		StringBuilder teamName = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			order[i] = Integer.parseInt(teams[i][1].substring(2));
		}
		Arrays.sort(order);

		for (int i = 0; i < 3; i++) {
			teamName.append(order[i]);
		}

		return teamName.toString();
	}

	public static String solve2(String[][] teams) {
		Map<Integer, Character> map = new HashMap<>();
		int[] order = new int[3];
		StringBuilder teamName = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			int solvedNum = Integer.parseInt(teams[i][0]);
			map.put(solvedNum, teams[i][2].charAt(0));
			order[i] = solvedNum;
		}

		Arrays.sort(order);

		for (int i = 2; i >= 0; i--) {
			teamName.append(map.get(order[i]));
		}

		return teamName.toString();
	}
}