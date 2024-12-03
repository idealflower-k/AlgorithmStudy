import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static int[] height;
	static List<Integer>[] graph;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());

		height = new int[N + 1];
		graph = new ArrayList[N + 1];
		dp = new int[N + 1];

		token = new StringTokenizer(buffer.readLine());
		for (int i = 1; i <= N; ++i) {
			height[i] = Integer.parseInt(token.nextToken());
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(buffer.readLine());
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(dfs(i));
		}
	}

	static int dfs(int node) {
		if (dp[node] != 0) {
			return dp[node];
		}

		dp[node] = 1;
		for (int next : graph[node]) {
			if (height[node] < height[next]) {
				dp[node] = Math.max(dp[node], dfs(next) + 1);
			}
		}
		return dp[node];
	}
}