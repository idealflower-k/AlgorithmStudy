package PGS;

import java.util.*;

class Poketmon {

    public static void main(String[] args) {
        int[] data = {3, 1, 2, 3};
        int answer = solution(data);
        System.out.println("answer = " + answer);
    }

    static public int solution(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int len = nums.length / 2;

        return Math.min(set.size(), len);
    }
}