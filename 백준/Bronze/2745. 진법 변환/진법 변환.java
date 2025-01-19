import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        String N = token.nextToken();
        int B = Integer.parseInt(token.nextToken());
        
        int result = convertToDec(N, B);
        
        System.out.print(result);
    }
    
    private static int convertToDec(String num, int base) {
        int res = 0;
        int power = 1;
        
        for (int i = num.length() - 1; i >= 0; --i) {
            char c = num.charAt(i);
            int digit = 0;
            if (Character.isDigit(c)) {
                digit = c - '0';
            } else {
                digit = (c - 'A') + 10;
            }
            res += digit * power;
            power *= base;
        }
        
        return res;
    }
}
