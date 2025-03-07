import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int low = Integer.parseInt(token.nextToken());
        int high = Integer.parseInt(token.nextToken());
        
        findPrime(low, high);
    }
    
    private static void findPrime(int low, int high) {
        boolean[] arr = new boolean[high - low + 1];
        Arrays.fill(arr, true);
        
        if (low <= 0) {
            arr[0] = false;
        }
        
        if (low <= 1 && high >= 1) {
            arr[1 - low] = false;
        }
        
        for (int i = 2; i * i <= high; ++i) {
            int start = Math.max(i * i, (int)(Math.ceil((double) low / i) * i));
            for (int j = start; j <= high; j += i) {
                arr[j - low] = false;
            }
        }
        
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i]) {
                System.out.println(i + low);
            }
        }
    }
}
