import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Stack<Integer> stack = new Stack<>();
    static List<Integer> result = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs(1, 0);
        System.out.println(sb.toString());
    }

    static void dfs(int num, int count) {
        if (count == n) {
            for (int i = 0; i < result.size(); ++i) {
                sb.append(result.get(i));
                if (i != result.size() - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        if (!stack.isEmpty()) {
            int top = stack.pop();
            result.add(top);
            dfs(num, count + 1);
            result.remove(result.size() - 1);
            stack.push(top);
        }

        if (num <= n) {
            stack.push(num);
            dfs(num + 1, count);
            stack.pop();
        }
    }
}