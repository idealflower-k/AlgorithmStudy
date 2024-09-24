import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder builder = new StringBuilder();
        builder.append("a = ").append(a).append("\n")
            .append("b = ").append(b);

        System.out.print(builder.toString());
    }
}