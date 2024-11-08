import java.io.*;
import java.util.*;

public class Main {

	static Stack<Integer> stack = new Stack<>();
	static char[] arr;
	static int[] pair;
	static boolean[] visited;
	static TreeSet<String> set = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		String input = buffer.readLine();


		arr = input.toCharArray();
		pair = new int[arr.length];
		visited = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				stack.push(i);
			} else if (arr[i] == ')') {
				pair[i] = stack.peek();
				pair[stack.peek()] = i;
				stack.pop();
			}
		}

		dfs(0, arr.length);

		set.remove(input);

		for (String s : set) {
			builder.append(s).append("\n");
		}
		System.out.println(builder);

	}

	public static void dfs(int idx, int len) {
		if (idx == len) {
			print();
			return;
		}

		if (arr[idx] == '(') {
			visited[idx] = true;
			visited[pair[idx]] = true;
			dfs(idx + 1, len);
			visited[idx] = false;
			visited[pair[idx]] = false;
		}

		dfs(idx + 1, len);
	}

	public static void print() {
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				temp.append(arr[i]);
			}
		}
		set.add(temp.toString());
	}
}