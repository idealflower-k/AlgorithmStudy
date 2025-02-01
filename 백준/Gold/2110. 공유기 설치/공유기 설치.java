import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int C;
    static int[] houses;
    static int result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        houses = new int[N];
        
        for (int i = 0; i < N; ++i) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(houses);
        binarySearch();
        
        System.out.print(result);
    }
    
    private static void binarySearch() {
        int left = 1;
        int right = houses[N - 1] - houses[0];
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlace(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
    
    private static boolean canPlace(int dist) {
        int cnt = 1;
        int last = 0;
        
        for (int i = 1; i < N; ++i) {
            if (houses[i] - houses[last] >= dist) {
                cnt++;
                last = i;
            }
            if (cnt == C) {
                return true;
            }
        }
        
        return false;
    }
}
