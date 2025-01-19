import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());
        
        String result = convertToBase(N, B);
        
        System.out.print(result);
    }
    
    private static String convertToBase(int num, int base) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            int temp = num % base;
            
            if (temp < 10) {
                sb.append((char)('0' + temp));
            } else {
                sb.append((char)('A' + (temp - 10)));
            }
            
            num /= base;
        }
        
        return sb.reverse().toString();
    }
}
