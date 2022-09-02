package me.tamsil.programmers;

import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        int[] answer = new Lotto().solution(lottos, win_nums);
        System.out.println(answer[0] + ", " + answer[1]);
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int minHitCount, maxHitCount;

        long count = Arrays.stream(lottos)
                .filter(num -> Arrays.stream(win_nums).anyMatch(num2 -> num2 == num))
                .count();

        long countZero = Arrays.stream(lottos)
                .filter(num -> num == 0)
                .count();

        minHitCount = (int) count;
        maxHitCount = (int) (count + countZero);

        answer[0] = getRanking(maxHitCount);
        answer[1] = getRanking(minHitCount);

        return answer;
    }

    private int getRanking(int count) {
        int rank = 0;

        switch (count) {
            case 6:
                rank = 1;
                break;
            case 5:
                rank = 2;
                break;
            case 4:
                rank = 3;
                break;
            case 3:
                rank = 4;
                break;
            case 2:
                rank = 5;
                break;
            default:
                rank = 6;
        }
        return rank;
    }
}
