package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13144 {
    public static int N;
    public static int[] arr, cnt;

    public static void solution() {
        long ans = 0;
        for (int L = 1, R = 0; L <= N; L++) {
            while (R + 1 <= N && cnt[arr[R + 1]] == 0) {
                R++;
                cnt[arr[R]]++;
            }

            ans += R - L + 1;
            cnt[arr[L]]--;
        }
        System.out.println(ans);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        cnt = new int[100000 + 1];
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
