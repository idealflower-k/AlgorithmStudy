import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(buffer.readLine());
        
        long left = 1;
        long right = M * 5L + 5;
        long result = -1;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long zero = countZero(mid);
            
            if (zero == M) {
                result = mid;
                right = mid - 1;
            } else if (zero < M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
        
    }
    
    public static long countZero(long n) {
        long count = 0;
        for (int i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
