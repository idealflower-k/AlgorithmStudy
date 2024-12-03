import java.io.*;
import java.util.*;

class Main {
	static int[][] map;
	static boolean[][] visited;
	static int size;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	static final String SUCCESS = "HaruHaru";
	static final String FAIL = "Hing";

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		size = Integer.parseInt(token.nextToken());
		map = new int[size][size];
		visited = new boolean[size][size];

		for (int i = 0; i < size; ++i) {
			token = new StringTokenizer(buffer.readLine());
			for (int j = 0; j < size; ++j) {
				map[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		if (bfs()) {
			System.out.println(SUCCESS);
		} else {
			System.out.println(FAIL);
		}
	}

	static boolean bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[]{0, 0});

		while (!que.isEmpty()) {
			int[] curr = que.poll();
			int x = curr[0];
			int y = curr[1];

			if (x == size - 1 && y == size - 1) {
				return true;
			}

			int len = map[x][y];
			for (int i = 0; i < 2; ++i) {
				int nx = x + (dx[i] * len);
				int ny = y + (dy[i] * len);
				if (isValid(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					que.offer(new int[]{nx, ny});
				}
			}
		}
		return false;
	}

	static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < size && y < size;
	}
}