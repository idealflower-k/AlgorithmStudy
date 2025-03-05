import java.io.*;
import java.util.*;

public class Main {
    
    static int[] devs;
    static int maxValue;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;
        
        N = Integer.parseInt(br.readLine());
        devs = new int[N];
        
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            devs[i] = Integer.parseInt(token.nextToken());
        }
        
        findMaxValue();
        System.out.print(maxValue);
    }
    
    private static void findMaxValue() {
        int left = 0;
        int right = N - 1;
        
        while (left < right) {
            int value = (right - left - 1) * Math.min(devs[left], devs[right]);
            maxValue = Math.max(maxValue, value);
            
            if (devs[left] < devs[right]) {
                left++;
            } else {
                right--;
            }
        }
    }
}