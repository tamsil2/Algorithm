package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_pointer {
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int[] arr;

    public static void solution() {
        Arrays.sort(arr, 1, N + 1);

        int L = 1;
        int R = N;
        int v1 = 0;
        int v2 = 0;
        int answer = Integer.MAX_VALUE;

        while (L < R) {
            if (Math.abs(answer) > Math.abs(arr[L] + arr[R])) {
                answer = arr[L] + arr[R];
                v1 = arr[L];
                v2 = arr[R];
            }

            if (arr[L] + arr[R] > 0) {
                L++;
            } else {
                R--;
            }
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
