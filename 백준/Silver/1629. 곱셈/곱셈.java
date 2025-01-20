import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());
        int C = Integer.parseInt(token.nextToken());
        
        long res = pow(A, B, C);
        
        System.out.print(res);
    }
    
    private static long pow(int a, int b, int c) {
        if (b == 0) {
            return 1;
        }
        
        long half = pow(a, b / 2, c);
        long res = (half * half) % c;
        
        if (b % 2 == 1) {
            res = (res * a) % c;
        }
        
        return res;
    }
}
