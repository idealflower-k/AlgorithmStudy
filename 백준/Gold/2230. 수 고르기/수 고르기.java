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
		for (int i = 0; i < size; ++i) {
			token = new StringTokenizer(buffer.readLine());
			nums[i] = Integer.parseInt(token.nextToken());
		}

		Arrays.sort(nums);
		int end = 0;
		for (int st = 0; st < size; ++st) {
			while (end < size && nums[end] - nums[st] < target) {
				end++;
			}
			if (end == size) {
				break;
			}
			min = Math.min(min, nums[end] - nums[st]);
		}

		System.out.println(min);
	}
}