import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static String[] words;
    static boolean[] visited;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("anta|tica", "");
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        dfs(0, 0);
        System.out.println(maxCount);
    }

    static void dfs(int alphaCount, int start) {
        if (alphaCount == K - 5) {
            int count = 0;
            for (String word : words) {
                boolean canRead = true;
                for (char c : word.toCharArray()) {
                    if (!visited[c - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) count++;
            }
            maxCount = Math.max(maxCount, count);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(alphaCount + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
