import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int layer = 1;
        int max = 1;
        
        while (max < N) {
            max += 6 * layer;
            layer++;
        }
        
        System.out.print(layer);
    }
}
