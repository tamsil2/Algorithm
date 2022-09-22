package me.tamsil.programmers;

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        int n = 12;
        int answer = new Solution().solution(n);
        System.out.println(answer);
    }

    public int solution(int n) {
        return IntStream.range(2, n)
                .filter(i -> n % i == 1)
                .findFirst()
                .getAsInt();
    }
}
