import java.util.*;
import java.io.*;

public class Main {

	static int stickCnt;
	static int[] heights;
	static int maxLoc;

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		stickCnt = Integer.parseInt(token.nextToken());
		heights = new int[1001];

		for (int i = 0; i < stickCnt; i++) {
			token = new StringTokenizer(buffer.readLine());
			int loc = Integer.parseInt(token.nextToken());
			int height = Integer.parseInt(token.nextToken());
			heights[loc] = height;

			if (heights[maxLoc] < height) {
				maxLoc = loc;
			}
		}

		System.out.println(getTotalArea());
	}

	public static int getTotalArea() {
		int total = 0;
		int tempHeight = 0;

		for (int i = 0; i <= maxLoc; i++) {
			if (tempHeight < heights[i]) {
				tempHeight = heights[i];
			}
			total += tempHeight;
		}

		tempHeight = 0;
		for (int i = 1000; i > maxLoc ; i--) {
			if (tempHeight < heights[i]) {
				tempHeight = heights[i];
			}
			total += tempHeight;
		}
		return total;
	}
}
