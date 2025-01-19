import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static int[] arr;
    static int max;
    static int result;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N];
        
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            int value = Integer.parseInt(token.nextToken());
            arr[i] = value;
            max = Math.max(max, value);
        }
        
        binarySearch();
        
        System.out.print(result);
    }
    
    private static void binarySearch() {
        int left = 0;
        int right = max - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canDivide(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
    
    private static boolean canDivide(int mid) {
        int cnt = 1;
        int minV = arr[0];
        int maxV = arr[0];
        
        for (int i = 1; i < N; ++i) {
            minV = Math.min(minV, arr[i]);
            maxV = Math.max(maxV, arr[i]);
            if (maxV - minV > mid) {
                cnt++;
                minV = arr[i];
                maxV = arr[i];
            }
        }
        return cnt <= M;
    }
}