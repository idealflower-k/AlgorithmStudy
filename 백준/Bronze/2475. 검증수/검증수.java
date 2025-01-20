import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int res = 0;
        
        for (int i = 0; i < 5; ++i) {
            res += Math.pow(Integer.parseInt(token.nextToken()), 2);
        }
        
        res = res % 10;

        System.out.print(res);
    }
}
