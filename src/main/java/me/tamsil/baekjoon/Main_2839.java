package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839 {
    private static int T, N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            N = Integer.parseInt(br.readLine());
            int fiveCount = N / 5;
            int answer = Integer.MAX_VALUE;
            for (int i = 0; i <= fiveCount; i++) {
                int reserve = N - (5 * i);
                if (reserve % 3 == 0) {
                    int threeCount = reserve / 3;
                    answer = (threeCount + i < answer) ? threeCount + i : answer;
                }
            }
            if(answer == Integer.MAX_VALUE) answer = -1;
            System.out.println(answer);
        }
    }
}
