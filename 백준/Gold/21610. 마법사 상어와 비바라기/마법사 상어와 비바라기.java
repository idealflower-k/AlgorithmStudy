import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int limitIdx;
	static int[][] board;
	static boolean[][] cloud;
	static int[][] dirs =  {
		{0, -1},
		{-1, -1},
		{-1, 0},
		{-1, 1},
		{0, 1},
		{1, 1},
		{1, 0},
		{1, -1}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		N = Integer.parseInt(token.nextToken());
		M = Integer.parseInt(token.nextToken());
		board = new int[N][N];
		cloud = new boolean[N][N];
		limitIdx = N - 1;

		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(buffer.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(token.nextToken());
			}
		}

		cloud[limitIdx][0] = true;
		cloud[limitIdx][1] = true;
		cloud[limitIdx - 1][0] = true;
		cloud[limitIdx - 1][1] = true;

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(buffer.readLine());
			int dir = Integer.parseInt(token.nextToken());
			int speed = Integer.parseInt(token.nextToken());
			command(dir, speed);

		}
		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += board[i][j];
			}
		}
		System.out.println(sum);
	}


	public static void command(int dir, int speed) {
		boolean[][] isRain =  moveCloudAndRain(dir, speed);
		copyWater(isRain);
		makeCloud(isRain);
	}

	public static boolean[][] moveCloudAndRain(int dir, int speed) {
		boolean[][] moved = new boolean[N][N];
		int[] move = dirs[dir - 1];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!cloud[i][j]) {
					continue;
				}

				int r = (N + ((i + (move[0] * speed)) % N)) % N;
				int c = (N + ((j + (move[1] * speed)) % N)) % N;
				board[r][c] += 1;
				moved[r][c] = true;
			}
		}
		return moved;
	}

	public static void copyWater(boolean[][] isRain) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isRain[i][j]) {
					continue;
				}
				board[i][j] += getCnt(i, j);
			}
		}
	}

	public static void makeCloud(boolean[][] isRain) {
		cloud = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isRain[i][j] && board[i][j] >= 2) {
					cloud[i][j] = true;
					board[i][j] -= 2;
				}
			}
		}
	}

	public static int getCnt(int r, int c) {
		int cnt = 0;
		for (int i = 1; i <= 7; i += 2) {
			int newR = dirs[i][0] + r;
			int newC = dirs[i][1] + c;
			if (isValid(newR, newC) && board[newR][newC] > 0) {
				cnt++;
			}
		}
		return cnt;
	}

	public static boolean isValid(int r, int c) {
		return r <= limitIdx && c <= limitIdx && r >= 0 && c >= 0;
	}
}