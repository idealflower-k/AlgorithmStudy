import java.io.*;
import java.util.*;

public class Main {

	static ArrayDeque<Character> deque = new ArrayDeque<>();
	static ArrayList<Boolean> isFirst = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());
		StringBuilder builder = new StringBuilder();

		int cmdNum = Integer.parseInt(token.nextToken());

		for (int i = 0; i < cmdNum; i++) {
			token = new StringTokenizer(buffer.readLine());
			String cmd = token.nextToken();
			if (cmd.equals("1")) {
				Character c = token.nextToken().charAt(0);
				cmd1(c);
			} else if (cmd.equals("2")) {
				Character c = token.nextToken().charAt(0);
				cmd2(c);
			} else {
				cmd3();
			}
		}
		if (deque.isEmpty()) {
			System.out.println(0);
		} else {
			for (Character character : deque) {
				builder.append(character);
			}
			System.out.println(builder);
		}

	}

	public static void cmd1(Character c) {
		deque.addLast(c);
		isFirst.add(false);
	}

	public static void cmd2(Character c) {
		deque.addFirst(c);
		isFirst.add(true);
	}

	public static void cmd3() {
		if (!deque.isEmpty()) {
			if (isFirst.get(isFirst.size() - 1)) {
				deque.removeFirst();
			} else {
				deque.removeLast();
			}
			isFirst.remove(isFirst.size() - 1);
		}
	}
}