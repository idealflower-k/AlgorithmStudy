import java.io.*;
import java.util.*;

class Main {
    static HashSet<Integer> set = new HashSet<>();
    static int[] parent;
    static int[] input;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(buffer.readLine());
        
        int len = Integer.parseInt(token.nextToken());
        input = new int[len];
        
        token = new StringTokenizer(buffer.readLine());
        for (int i = 0; i < len; ++i) {
            int data = Integer.parseInt(token.nextToken());
            input[i] = data;
            set.add(data);
        }
        int dataSize = set.size();
        visited = new boolean[dataSize];
        parent = new int[dataSize];
        
        visited[input[0]] = false;
        for (int i = 0; i < dataSize; ++i) {
            parent[i] = i;
        }
        parent[input[0]] = -1;
        
        for (int i = 0; i < len - 1; ++i) {
            int prev = input[i];
            int curr = input[i + 1];
            
            if (!visited[curr] && parent[prev] != curr) {
                parent[curr] = prev;
            }
        }
        
        System.out.println(dataSize);
        for (int data : parent) {
            System.out.print(data + " ");
        }
    }
}