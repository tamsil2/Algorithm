package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {
    public static StringTokenizer st;
    public static int N, S, answer;
    public static int[] arr;

    public static void solution() {
        int R = 0;
        int sum = 0;
        answer = Integer.MAX_VALUE;
        for (int L = 1; L <= N; L++) {
            // 맨 왼쪽 숫자를 한개 뺀다
            sum -= arr[L - 1];

            // 루프를 돌면서 sum보다 크지 않을때까지 R을 땡기면서 sum을 채운다
            while (R < N && sum < S) {
                sum += arr[++R];
            }

            if (sum >= S) {
                answer = Math.min(answer, R - L + 1);
            }
        }
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
