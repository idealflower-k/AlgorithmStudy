import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] arr;
    static int[] result;
    static int minValue = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[2];
        
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        
        findResult();
        System.out.print(result[0] + " " + result[1]);        
    }
    
    private static void findResult() {
        int left = 0;
        int right = N - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            int value = 0 + Math.abs(sum);
            
            if (value < minValue) {
                minValue = value;
                result[0] = arr[left];
                result[1] = arr[right];
            }
            
            if (sum == 0) {
                return;
            }
            
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}
