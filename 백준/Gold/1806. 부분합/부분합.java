import java.io.*;
import java.util.*;

public class Main {
	static int[] nums;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		int size = Integer.parseInt(token.nextToken());
		int target = Integer.parseInt(token.nextToken());

		nums = new int[size];
		token = new StringTokenizer(buffer.readLine());
		for (int i = 0; i < size; ++i) {
			nums[i] = Integer.parseInt(token.nextToken());
		}

		int en = 0;
		int total = nums[0];
		for (int st = 0; st < size; ++st) {
			while (en < size && total < target) {
				en++;
				if (en != size) {
					total += nums[en];
				}
			}
			if (en == size) {
				break;
			}
			min = Math.min(min, en - st + 1);
			total -= nums[st];
		}
		if (min == Integer.MAX_VALUE) {
			min = 0;
		}
		System.out.println(min);
	}
}