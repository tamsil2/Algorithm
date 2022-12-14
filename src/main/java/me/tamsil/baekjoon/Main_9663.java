package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663 {
    public static int N, answer;
    public static int[] arr;

    public static boolean isAttack(int x1, int y1, int x2, int y2) {
        if (y1 == y2) {
            return true;
        }
        if ((x1 - y1) == (x2 - y2)) {
            return true;
        }
        if ((x1 + y1) == (x2 + y2)) {
            return true;
        }
        return false;
    }

    public static void solution(int row) {
        if (row == N + 1) {
            answer++;
        } else {
            for (int col = 1; col <= N; col++) {
                boolean attack = false;
                for (int i = 1; i <= row - 1; i++) {
                    if (isAttack(row, col, i, arr[i])) {
                        attack = true;
                        break;
                    }
                }

                if (!attack) {
                    arr[row] = col;
                    solution(row + 1);
                    arr[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        answer = 0;
        solution(1);
        System.out.println(answer);
    }
}
