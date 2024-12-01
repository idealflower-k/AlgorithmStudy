import java.io.*;
import java.util.*;

class Main {

	public static class Node {
		int to;
		int cost;

		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	static HashMap<Integer, ArrayList<Node>> tree = new HashMap<>();
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		int size = Integer.parseInt(token.nextToken());
		int targetCnt = Integer.parseInt(token.nextToken());

		for (int i = 1; i <= size; ++i) {
			tree.put(i, new ArrayList<>());
		}
		visited = new boolean[size + 1];

		for (int i = 0; i < size - 1; ++i) {
			token = new StringTokenizer(buffer.readLine());
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			int cost = Integer.parseInt(token.nextToken());
			tree.get(from).add(new Node(to, cost));
			tree.get(to).add(new Node(from, cost));
		}

		for (int i = 0; i < targetCnt; ++i) {
			token = new StringTokenizer(buffer.readLine());
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());
			bfs(from, to);
		}
		System.out.println(sb);
	}

	static void bfs(int start, int end) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[]{start, 0});
		Arrays.fill(visited, false);

		while (!que.isEmpty()) {
			int[] curr = que.poll();
			int from = curr[0];

			if (from == end) {
				sb.append(curr[1]).append('\n');
				return;
			}

			ArrayList<Node> nodes = tree.get(from);
			for (Node node : nodes) {
				int to = node.to;
				int cost = node.cost;
				if (!visited[to]) {
					que.add(new int[] {to, curr[1] + cost});
					visited[to] = true;
				}
			}
		}

	}
}