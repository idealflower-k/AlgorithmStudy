import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
        
        int digonal = 1;
        int cnt = 0;
        
        while (cnt < X) {
            cnt += digonal;
            digonal++;
        }
        digonal--;
        int pos = cnt - X;

        if (digonal % 2 == 0) {
            System.out.print((digonal - pos) + "/" + (1 + pos));
        } else {
            System.out.print((1 + pos) + "/" + (digonal - pos));
        }
    }
}
