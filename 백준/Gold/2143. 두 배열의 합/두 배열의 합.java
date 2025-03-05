import java.io.*;
import java.util.*;

public class Main {
    
    static long T;
    static int n;
    static int m;
    static long[] arrA;
    static long[] arrB;
    static List<Long> sumA = new ArrayList<>();
    static HashMap<Long, Long> sumBCnt = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        T = Long.parseLong(token.nextToken());
        n = Integer.parseInt(br.readLine());
        
        arrA = new long[n];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            arrA[i] = Long.parseLong(token.nextToken());
        }
        
        m = Integer.parseInt(br.readLine());
        arrB = new long[m];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; ++i) {
            arrB[i] = Long.parseLong(token.nextToken());
        }
        
        for (int i = 0; i < n; ++i) {
            long sum = 0;
            for (int j = i; j < n; ++j) {
                sum += arrA[j];
                sumA.add(sum);
            }
        }
        
        for (int i = 0; i < m; ++i) {
            long sum = 0;
            for (int j = i; j < m; ++j) {
                sum += arrB[j];
                sumBCnt.put(sum, sumBCnt.getOrDefault(sum, 0L) + 1);
            }
        }
        
        long result = 0;
        for (long a : sumA) {
            long target = T - a;
            result += sumBCnt.getOrDefault(target, 0L);
        }

        System.out.print(result);
    }
}