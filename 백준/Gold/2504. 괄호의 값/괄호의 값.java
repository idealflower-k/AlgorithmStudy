import java.io.*;
import java.util.*;

public class Main {

	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String input = buffer.readLine();

		int result = 0;
		int temp = 1;
		boolean isValid = true;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (c == '(') {
				stack.push(c);
				temp *= 2;
			} else if (c == '[') {
				stack.push(c);
				temp *= 3;
			} else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					isValid = false;
					break;
				}
				if (input.charAt(i - 1) == '(') {
					result += temp;
				}
				stack.pop();
				temp /= 2;
			} else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					isValid = false;
					break;
				}
				if (input.charAt(i - 1) == '[') {
					result += temp;
				}
				stack.pop();
				temp /= 3;
			}
		}

		if (!stack.isEmpty() || !isValid) {
			System.out.println(0);
		} else {
			System.out.println(result);
		}

	}
}