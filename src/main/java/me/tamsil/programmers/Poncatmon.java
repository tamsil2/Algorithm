package me.tamsil.programmers;

import java.util.Arrays;

public class Poncatmon {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};
        int answer = new Poncatmon().solution(nums);
        System.out.println("answer = " + answer);
    }

    public int solution(int[] nums) {
        int answer = 0;
        int count = (int) Arrays.stream(nums)
                .distinct()
                .count();
        answer = (count > nums.length / 2) ? nums.length / 2 : count;
        return answer;
    }
}
