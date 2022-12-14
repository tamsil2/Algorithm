package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7795 {
    public static BufferedReader br;
    public static StringTokenizer st;
    public static int T, N, M;
    public static int[] A, B;

    public static int binarySearch(int L, int R, int value) {
        int result = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (B[mid] < value) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }

    public static void solution() {
        int answer = 0;
        Arrays.sort(B);
        for (int i = 1; i <= N; i++) {
            answer += binarySearch(1, M, A[i]);
        }
        System.out.println(answer);
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        B = new int[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            input();
            solution();
        }
    }
}
