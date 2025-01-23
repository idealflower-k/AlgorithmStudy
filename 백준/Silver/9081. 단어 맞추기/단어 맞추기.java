import java.io.*;
import java.util.*;

public class Main {
    
    static char[] word;
    static int T;
    static String S;
    static String result;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        T = Integer.parseInt(token.nextToken());
        
        for (int i = 0; i < T; ++i) {
            S = br.readLine();
            word = S.toCharArray();
            nextPermutation(word);

            System.out.println(new String(word));
        }
    }
    
    private static void nextPermutation(char[] word) {
        int i = word.length - 1;
        while (i > 0 && word[i - 1] >= word[i]) {
            --i;
        }
        
        if (i <= 0) {
            return;
        }
        
        int j = word.length - 1;
        while (j > 0 && word[j] <= word[i - 1]) {
            --j;
        }
        
        swap(word, i - 1, j);
        
        reverse(word, i, word.length - 1);
    }
    
    private static void swap(char[] word, int a, int b) {
        char temp = word[a];
        word[a] = word[b];
        word[b] = temp;
    }
    
    private static void reverse(char[] word, int start, int end) {
        while (start < end) {
            swap(word, start, end);
            start++;
            end--;
        }
    }
    

}
