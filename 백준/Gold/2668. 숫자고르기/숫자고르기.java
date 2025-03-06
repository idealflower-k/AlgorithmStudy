

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {

    static int[] targets;
    static TreeSet<Integer> resultSet = new TreeSet<>();
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        targets = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (!resultSet.contains(i)) {
                Arrays.fill(visited, false);
                visited[i] = true;
                dfs(i, targets[i]);
            }
        }

        System.out.println(resultSet.size());
        for (Integer i : resultSet) {
            System.out.println(i);
        }
    }
    // idx == 시작 번호
    static boolean dfs(int idx, int target) {
        // 탈출 조건7
        //
        if (target == idx) {
            resultSet.add(idx);
            return true;
        }

        // 실패 조건
        if (visited[target]) {
            return false;
        }

        visited[target] = true;

        if (dfs(idx, targets[target])) {
            resultSet.add(target);
            return true;
        }

        return false;
    }
}
