import java.io.*;
import java.util.*;

class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		size = Integer.parseInt(token.nextToken());
		map = new int[size][size];

		for (int i = 0; i < size; ++i) {
			String line = buffer.readLine();
			for (int j = 0; j < size; ++j) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		boolean[][] visited = new boolean[size][size];
		pq.offer(new int[]{0, 0, 0});
		visited[0][0] = true;

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int x = curr[0];
			int y = curr[1];
			int cnt = curr[2];

			if (x == size - 1 && y == size - 1) {
				return cnt;
			}

			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isValid(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if (map[nx][ny] == 1) {
						pq.offer(new int[] {nx, ny, cnt});
					} else {
						pq.offer(new int[]{nx, ny, cnt + 1});
					}
				}
			}
		}
		return -1;
	}

	static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < size && y < size;
	}
}