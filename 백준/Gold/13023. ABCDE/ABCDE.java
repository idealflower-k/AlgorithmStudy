import java.io.*;
import java.util.*;

public class Main {
    
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N;
    static int M;
    static HashSet<Integer> set = new HashSet<>();
    static boolean res;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        
        for (int i = 0; i < N; ++i) {
            list.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < M; ++i) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }
        
        for (int i = 0; i < list.size(); ++i) {
            if (!res) {
                dfs(i);            
            }
        }
        
        if (res) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
    
    public static void dfs(int num) {
        if (!res && set.size() == 5) {
            res = true;
            return;
        }
        
        ArrayList<Integer> friends = list.get(num);
        for (int i = 0; i < friends.size(); ++i) {
            int friend = friends.get(i);
            if (!res && !set.contains(friend)) {
                set.add(friend);
                dfs(friend);
                set.remove(friend);
            }
        }
    }
}