package me.tamsil.programmers;

import java.util.Arrays;

public class MakeMinNumber {
    public static void main(String[] args) {
//        int[] A = {1, 4, 2};
//        int[] B = {5, 4, 4};

        int[] A = {1, 2};
        int[] B = {3, 4};

        int answer = new MakeMinNumber().solution(A, B);
        System.out.println(answer);
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length -i -1];
        }

        return answer;
    }
}
