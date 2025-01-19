import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int dot = 2;
        for (int i = 0; i < N; ++i) {
            dot = (dot * 2) - 1;
        }
        
        int result = dot * dot;
        System.out.print(result);
    }
}
