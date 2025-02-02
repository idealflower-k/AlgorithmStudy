import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = 0;
        int mr = 0;
        int mc = 0;
        
        for (int i = 1; i <= 9; ++i) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; ++j) {
                int value = Integer.parseInt(token.nextToken());
                if (value >= max) {
                    max = value;
                    mr = i;
                    mc = j;
                }
            }
        }
        
        System.out.println(max);
        System.out.print(mr + " " + mc);
    }
}
