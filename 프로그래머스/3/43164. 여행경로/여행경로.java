import java.util.*;
import java.io.*;

class Solution {
    public static boolean[] visited;
    public static ArrayList<String> results = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(results);
        
        return results.get(0).split(" ");
    }
    
    public static void dfs(String begin, String result, int cnt, String[][] tickets) {
        if (cnt == tickets.length) {
            results.add(result);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(begin)) {
                visited[i] = true;
                dfs(tickets[i][1], result + " " + tickets[i][1], cnt + 1, tickets);
                visited[i] = false;
            }
        }
        return;
    }
}