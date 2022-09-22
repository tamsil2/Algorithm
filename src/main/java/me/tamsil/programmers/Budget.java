package me.tamsil.programmers;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
//        int[] d = {2, 2, 3, 3};
        int budget = 9;
        int answer = new Budget().solution(d, budget);
        System.out.println(answer);
    }

    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        int sum = 0;
        for (int i : d) {
            if (budget >= sum + i) {
                sum += i;
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
