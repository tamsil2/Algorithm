package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {
    public static int N, C;
    public static int[] A;

    public static boolean isAvailable(int num) {
        int cnt = 1;
        int last = A[1];
        for (int i = 2; i <= N; i++) {
            if (A[i] - last >= num) {
                last = A[i];
                cnt++;
            }
        }
        return cnt >= C;
    }

    public static void solution() {
        Arrays.sort(A, 1, N + 1);

        int L = 0, R = 1000000000;
        int ans = 0, mid = 0;
        while (L <= R) {
            mid = (L + R) / 2;
            if (isAvailable(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
