import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();

		for (int i = 0; i < a.length(); i++) {
			char target = a.charAt(i);
			if (Character.isUpperCase(target)) {
				System.out.print(Character.toLowerCase(target));
			} else if (Character.isLowerCase(target)) {
				System.out.print(Character.toUpperCase(target));
			} else {
				System.out.print(target);
			}
		}
	}
}