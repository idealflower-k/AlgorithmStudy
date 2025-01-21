import java.io.*;
import java.util.*;

public class Main {
    
    static Deque<Integer> backQue = new ArrayDeque<>();
    static Deque<Integer> frontQue = new ArrayDeque<>();
    static int currentPage;
    static int N;
    static int Q;
    static int C;
    static int currCash;
    static int[] cashSize;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(token.nextToken());
        Q = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        
        cashSize = new int[N + 1];
        
        token = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i) {
            cashSize[i] = Integer.parseInt(token.nextToken());
        }
        
        for (int i = 0; i < Q; ++i) {
            token = new StringTokenizer(br.readLine());
            String cmd = token.nextToken();
            
            if (cmd.equals("B")) {
                backward();
            } else if (cmd.equals("F")) {
                frontward();
            } else if (cmd.equals("A")) {
                int page = Integer.parseInt(token.nextToken());
                access(page);
            } else {
                compression();
            }
        }
        
        sb.append(currentPage);
        sb.append("\n");
        if (backQue.size() > 0) {
            for (int i = backQue.size(); i > 0; --i) {
                int page = backQue.removeLast();
                sb.append(page);
                if (i != 1) {
                    sb.append(" ");
                }
            }
        } else {
            sb.append(-1);
        }
        sb.append("\n");
        
        if (frontQue.size() > 0) {
            for (int i = frontQue.size(); i > 0; --i) {
                int page = frontQue.removeLast();
                sb.append(page);
                if (i != 1) {
                    sb.append(" ");
                }
            }
        } else {
            sb.append(-1);
        }

        System.out.print(sb);
    }
    
    private static void backward() {
        if (backQue.size() == 0) {
            return;
        }
        
        frontQue.addLast(currentPage);
        currentPage = backQue.removeLast();
    }
    
    private static void frontward() {
        if (frontQue.size() == 0) {
            return;
        }
        
        backQue.addLast(currentPage);
        currentPage = frontQue.removeLast();
    }
    
    private static void access(int page) {
        while (frontQue.size() > 0) {
            int p = frontQue.removeFirst();
            currCash -= cashSize[p];
        }
        
        if (currentPage != 0) {
            backQue.addLast(currentPage);        
        }
        
        currentPage = page;
        currCash += cashSize[page];
        
        while (currCash > C && backQue.size() > 0) {
            int p = backQue.removeFirst();
            currCash -= cashSize[p];
        }
    }
    
    private static void compression() {
        Deque<Integer> temp = new ArrayDeque<>();
        
        if (backQue.size() > 0) {
            int first = backQue.removeFirst();
            temp.addLast(first);
            while (backQue.size() > 0) {
                int curr = backQue.removeFirst();
                if (curr == first) {
                    currCash -= cashSize[curr];
                    continue;
                }
                temp.addLast(curr);
                first = curr;
            }
            backQue = temp;
        }    
    }
        
}
