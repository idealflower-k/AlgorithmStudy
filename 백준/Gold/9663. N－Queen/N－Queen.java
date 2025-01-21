import java.io.*;
import java.util.*;

public class Main {
    
    static boolean[][] map;
    static int N;
    static int result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        
        dfs(0);
        
        System.out.print(result);
    }
    
    private static void dfs(int r) {
        if (r == N) {
            result++;
            return;
        }
        
        for (int i = 0; i < N; ++i) {
            if (canPut(r, i)) {
                map[r][i] = true;
                dfs(r + 1);
                map[r][i] = false;
            }
        }
    }
    
    private static boolean canPut(int r, int c) {
        for (int i = 0; i < r; ++i) {
            if (map[i][c]) {
                return false;
            }
        }
        
        for (int i = r, j = c; i >= 0 && j >= 0; --i, --j) {
            if (map[i][j]) {
                return false;
            }
        }

        for (int i = r, j = c; i >= 0 && j < N; --i, ++j) {
            if (map[i][j]) {
                return false;
            }
        }

        return true;
    }
    
}
