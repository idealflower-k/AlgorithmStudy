import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String base = N + " " + "*" + " ";
        
        for (int i = 1; i <= 9; ++i) {
            sb.append(base)
                .append(i)
                .append(" = ")
                .append(N * i)
                .append("\n");
        }
        
        System.out.print(sb);
    }
}
