import java.io.*;
import java.util.*;

public class Main {
    
    static class Menu {
        int spicy;
        int sweet;
        
        Menu(int spicy, int sweet) {
            this.spicy = spicy;
            this.sweet = sweet;
        }
    }
    static int N;
    static int Q;
    static Menu[] menus;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(token.nextToken());
        Q = Integer.parseInt(token.nextToken());
        
        menus = new Menu[N];
        for (int i = 0; i < N; ++i) {
            token = new StringTokenizer(br.readLine());
            int spicy = Integer.parseInt(token.nextToken());
            int sweet = Integer.parseInt(token.nextToken());
            menus[i] = new Menu(spicy, sweet);
        }
        
        Arrays.sort(menus, Comparator.comparingInt(m -> m.spicy));
        
        for (int i = 0; i < Q; ++i) {
            token = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(token.nextToken());
            int v = Integer.parseInt(token.nextToken());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            
            int[] bounds = spicyMenuFind(u, v);
            int cnt = 0;
            for (int j = bounds[0]; j < bounds[1]; ++j) {
                if (menus[j].sweet >= x && menus[j].sweet <= y) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        
        System.out.println(sb);
    }
    
    private static int[] spicyMenuFind(int u, int v) {
        int start = lowerBound(u);
        int end = upperBound(v);
        
        return new int[]{start, end};
    }
    
    private static int lowerBound(int target) {
        int left = 0;
        int right = menus.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (menus[mid].spicy < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static int upperBound(int target) {
        int left = 0;
        int right = menus.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (menus[mid].spicy <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}