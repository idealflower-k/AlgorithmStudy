import java.io.*;
import java.util.*;

public class Main {
	static long[] start = new long[2];
	static long[] end = new long[2];
	static long[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		int numNavi = Integer.parseInt(token.nextToken());
		result = new long[numNavi];

		token = new StringTokenizer(buffer.readLine());
		start[0] = Long.parseLong(token.nextToken());
		start[1] = Long.parseLong(token.nextToken());
		end[0] = Long.parseLong(token.nextToken());
		end[1] = Long.parseLong(token.nextToken());

		for (int i = 0; i < numNavi; i++) {
			token = new StringTokenizer(buffer.readLine());
			int visitedNum = Integer.parseInt(token.nextToken());
			long prevX = start[0];
			long prevY = start[1];
			for (int j = 0; j < visitedNum; j++) {
				token = new StringTokenizer(buffer.readLine());
				long x = Long.parseLong(token.nextToken());
				long y = Long.parseLong(token.nextToken());
				result[i] += Math.abs(prevX - x) + Math.abs(prevY - y);
				prevX = x;
				prevY = y;
			}
			result[i] += Math.abs(prevX - end[0]) + Math.abs(prevY - end[1]);
		}

		int answer = 0;
		for (int i = 1; i < result.length; i++) {
			if (result[answer] > result[i]) {
				answer = i;
			}
		}

		System.out.println(answer + 1);

	}
}