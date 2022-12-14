package me.tamsil.programmers;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;

        int[] answer = new Carpet().solution(brown, yellow);
        Arrays.stream(answer)
                .forEach(n -> {
                    System.out.print(n + " ");
                });
        System.out.println();
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int width = 0;
        int height = 0;

        int count = 0;
        count = answer[0] * answer[1] - brown - yellow - 8;


        return answer;
    }
}
