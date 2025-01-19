import java.io.*;
import java.util.*;

public class Main {
    
    static int[] changes = {25, 10, 5, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int testCnt = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < testCnt; ++i) {
            int target = Integer.parseInt(br.readLine());
            
            for (int j = 0; j < 4; ++j) {
                int cnt = target / changes[j];
                target -= changes[j] * cnt;
                sb.append(cnt);
                if (j != 3) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
