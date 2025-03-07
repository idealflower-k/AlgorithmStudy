import java.io.*;
import java.util.*;

public class Main {
    
    static int[] soldiers;
    static ArrayList<Integer> lds = new ArrayList<>();
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        soldiers = new int[N];
        
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            soldiers[i] = Integer.parseInt(token.nextToken());
        }
        
        for (int i = 0; i < N; ++i) {
            int curr = soldiers[i];
            
            int pos = Collections.binarySearch(lds, curr, Collections.reverseOrder());
            
            if (pos < 0) {
                pos = -(pos + 1);
            }
            
            if (pos < lds.size()) {
                lds.set(pos, curr);
            } else {
                lds.add(curr);
            }
        }
        
        System.out.print(N - lds.size());
    }
}
