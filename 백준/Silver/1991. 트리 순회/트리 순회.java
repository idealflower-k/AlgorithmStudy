import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int left;
        int right;
        
        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static Node[] tree;
    static String[] res;
    static StringBuilder sb = new StringBuilder();
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(token.nextToken());
        tree = new Node[N];
        res = new String[3];
        
        for (int i = 0; i < N; ++i) {
            token = new StringTokenizer(br.readLine());
            char curr = token.nextToken().charAt(0);
            char left = token.nextToken().charAt(0);
            char right = token.nextToken().charAt(0);
            int c = curr - 'A';
            int l = -1;
            int r = -1;
            
            if (left != '.') {
                l = left - 'A';
            }
            if (right != '.') {
                r = right - 'A';
            }
            tree[c] = new Node(l, r);
        }
        
        preorderTraversal(0);
        sb.append("\n");
        inorderTraversal(0);
        sb.append("\n");
        postorderTraversal(0);
        
        System.out.print(sb);
    }
    
    private static void preorderTraversal(int curr) {
        sb.append((char)(curr + 'A'));
        
        Node currNode = tree[curr];
        
        if (currNode.left != -1) {
            preorderTraversal(currNode.left);
        }
        if (currNode.right != -1) {
            preorderTraversal(currNode.right);
        }
    }
    
    private static void inorderTraversal(int curr) {
        Node currNode = tree[curr];
        
        if (currNode.left != -1) {
            inorderTraversal(currNode.left);
        }
        sb.append((char)(curr + 'A'));
        if (currNode.right != -1) {
            inorderTraversal(currNode.right);
        }
    }
    
    private static void postorderTraversal(int curr) {
        Node currNode = tree[curr];
        
        if (currNode.left != -1) {
            postorderTraversal(currNode.left);
        }
        if (currNode.right != -1) {
            postorderTraversal(currNode.right);
        }
        sb.append((char)(curr + 'A'));
    }
}
