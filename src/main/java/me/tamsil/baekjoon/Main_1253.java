package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 좋다
 */
public class Main_1253 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int[] A;

    static boolean isGoodNumber(int idx) {
        int L = 1, R = N;
        while (L < R) {
            if (L == idx) {
                L++;
            } else if (R == idx) {
                R--;
            } else {
                if (A[idx] > A[L] + A[R]) {
                    L++;
                } else if (A[idx] < A[L] + A[R]) {
                    R--;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    static void solution() {
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNumber(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
