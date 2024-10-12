package hash;

import java.io.IOException;
import java.util.Arrays;

public class ChanningHash {

	static final int M = 10000003;
	static final int a = 1000;
	static final int MX = 500005;
	static int[] head = new int[M];
	static int[] pre = new int[MX];
	static int[] nxt = new int[MX];
	static String[] key = new String[MX];
	static int[] val = new int[MX];
	static int unused = 0;

	public static void main(String[] args) throws IOException {
		Arrays.fill(head, -1);
		Arrays.fill(pre, -1);
		Arrays.fill(nxt, -1);

		test();
	}

	static void test() {
		// 삽입 테스트
		System.out.println("=== 삽입 테스트 ===");
		insert("apple", 5);
		insert("banana", 3);
		insert("cherry", 8);
		System.out.println("apple의 값: " + val[find("apple")]);
		System.out.println("banana의 값: " + val[find("banana")]);
		System.out.println("cherry의 값: " + val[find("cherry")]);

		// 중복 키 삽입 테스트
		System.out.println("\n=== 중복 키 삽입 테스트 ===");
		insert("apple", 10);
		System.out.println("apple의 새 값: " + val[find("apple")]);

		// 검색 테스트
		System.out.println("\n=== 검색 테스트 ===");
		int idx = find("banana");
		System.out.println("banana 찾기: " + (idx != -1 ? "성공" : "실패"));
		idx = find("grape");
		System.out.println("grape 찾기: " + (idx != -1 ? "성공" : "실패"));

		// 삭제 테스트
		System.out.println("\n=== 삭제 테스트 ===");
		erase("banana");
		idx = find("banana");
		System.out.println("banana 삭제 후 찾기: " + (idx != -1 ? "성공" : "실패"));

		// 존재하지 않는 키 삭제 시도
		System.out.println("\n=== 존재하지 않는 키 삭제 테스트 ===");
		erase("grape");
		System.out.println("grape 삭제 시도 (아무 일도 일어나지 않아야 함)");

		// 많은 데이터 삽입 테스트
		System.out.println("\n=== 많은 데이터 삽입 테스트 ===");
		for (int i = 0; i < 10000; i++) {
			insert("key" + i, i);
		}
		System.out.println("10000개 데이터 삽입 완료");
		System.out.println("key5000의 값: " + val[find("key5000")]);
	}

	static int find(String k) {
		int code = myHash(k);
		int idx = head[code];

		while (idx != -1) {
			if (key[idx].equals(k)) {
				return idx;
			}
			idx = nxt[idx];
		}
		return -1;
	}

	static void insert(String k, int v) {
		int idx = find(k);

		if (idx != -1) {
			val[idx] = v;
			return;
		}
		int code = myHash(k);
		key[unused] = k;
		val[unused] = v;
		if (head[code] != -1) {
			nxt[unused] = head[code];
			pre[head[code]] = unused;
		}
		head[code] = unused;
		unused++;
	}

	static void erase(String k) {
		int idx = find(k);

		if (idx == -1) {
			return;
		}
		if (pre[idx] != -1) {
			nxt[pre[idx]] = nxt[idx];
		}
		if (nxt[idx] != -1) {
			pre[nxt[idx]] = pre[idx];
		}
		int code = myHash(k);
		if (head[code] == idx) {
			head[code] = nxt[idx];
		}
	}

	static int myHash(String s) {
		int code = 0;
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			code = ((code * a + aChar) % M + M) % M;
		}
		return code;
	}

}
