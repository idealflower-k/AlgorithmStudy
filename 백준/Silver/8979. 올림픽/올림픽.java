import java.io.*;
import java.util.*;

// TODO: 가중치는 안됨, class를 구현하고 람다식으로 정렬
public class Main {
	public static class node {
		int id, gold, silver, brown;

		public node(int id, int gold, int silver, int brown) {
			this.id = id;
			this.gold = gold;
			this.silver = silver;
			this.brown = brown;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		int numCountry = Integer.parseInt(token.nextToken());
		int target = Integer.parseInt(token.nextToken());

		node[] value = new node[numCountry];

		for (int i = 0; i < numCountry; i++) {
			token = new StringTokenizer(buffer.readLine());
			int num = Integer.parseInt(token.nextToken());
			int gold = Integer.parseInt(token.nextToken());
			int silver = Integer.parseInt(token.nextToken());
			int brown = Integer.parseInt(token.nextToken());

			value[i] = new node(num, gold, silver, brown);
		}

		Arrays.sort(value, (a, b) -> {
			if (a.gold != b.gold) {
				return b.gold - a.gold;
			}
			if (a.silver != b.silver) {
				return b.silver - a.silver;
			}
			return b.brown - a.brown;
		});

		int result = 1;

		for (int i = 0; i < numCountry; i++) {
			if (i > 0 && !isSameMedal(value[i], value[i - 1])) {
				result = i + 1;
			}
			if (value[i].id == target) {
				System.out.println(result);
				break;
			}
		}
	}

	public static boolean isSameMedal(node a, node b) {
		return a.gold == b.gold && a.silver == b.silver && a.brown == b.brown;
	}
}