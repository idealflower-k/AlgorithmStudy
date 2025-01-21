import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        int h = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int s = Integer.parseInt(token.nextToken());
        int q = Integer.parseInt(br.readLine());
        
        long totalTime = h * 3600L + m * 60L + s;
        
        for (int i = 0; i < q; ++i) {
            token = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(token.nextToken());
            
            if (cmd == 1) {
                int time = Integer.parseInt(token.nextToken());
                totalTime = (totalTime + time) % 86400;
                if (totalTime < 0) totalTime += 86400;
            }
            
            if (cmd == 2) {
                int time = Integer.parseInt(token.nextToken());
                totalTime = (totalTime - time) % 86400;
                if (totalTime < 0) totalTime += 86400;
            }
            
            if (cmd == 3) {
                long currentTime = totalTime % 86400;
                if (currentTime < 0) currentTime += 86400;
                
                int hour = (int) (currentTime / 3600);
                int minute = (int) ((currentTime % 3600) / 60);
                int second = (int) (currentTime % 60);
                
                System.out.println(hour + " " + minute + " " + second);
            }
        }
    }
}