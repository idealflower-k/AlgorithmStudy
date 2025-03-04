import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static int[] setArr;
    static int[] trueArr;
    static int[][] parties;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        
        setArr = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            setArr[i] = i;
        }
        
        token = new StringTokenizer(br.readLine());
        int trueNum = Integer.parseInt(token.nextToken());
        trueArr = new int[trueNum];
        for (int i = 0; i < trueNum; ++i) {
            trueArr[i] = Integer.parseInt(token.nextToken());
        }
        
        parties = new int[M][N];
        for (int i = 0; i < M; ++i) {
            token = new StringTokenizer(br.readLine());
            int peopleNum = Integer.parseInt(token.nextToken());
            for (int j = 0; j < peopleNum; ++j) {
                int num = Integer.parseInt(token.nextToken());
                parties[i][j] = num;
                if (j > 0) {
                    union(parties[i][j - 1], num);
                }
            }
        }
        
        int result = 0;
        for (int[] party : parties) {
            boolean isTrue = false;
            for (int i = 0; i < N && party[i] != 0; ++i) {
                for (int num : trueArr) {
                    if (find(num) == find(party[i])) {
                        isTrue = true;
                        break;
                    }
                }
                if (isTrue) {
                    break;
                }
            }
            if (!isTrue) {
                result++;
            }
        }
        System.out.print(result);
    }
    
    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        setArr[rootY] = rootX;
    }
    
    private static int find(int x) {
        if (setArr[x] == x) {
            return x;
        }
        
        int root = find(setArr[x]);
        setArr[x] = root;
        return root;
    }
}