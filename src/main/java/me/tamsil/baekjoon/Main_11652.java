package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11652 {
    public static int N, maxCnt, currCnt;
    public static long maxNum;
    public static long[] A;

    public static void solution() {
        Arrays.sort(A, 1, N + 1);
        maxCnt = 1;
        currCnt = 1;
        maxNum = A[1];

        for (int i = 2; i <= N; i++) {
            if (A[i - 1] == A[i]) {
                currCnt++;
            } else {
                currCnt = 1;
            }

            if (currCnt > maxCnt) {
                maxCnt = currCnt;
                maxNum = A[i];
            }
        }
        System.out.println(maxNum);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
