package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2470_binary {
    public static StringBuilder sb = new StringBuilder();
    public static int N;
    public static int[] A;

    public static int lower_bound(int L, int R, int X) {
        // X보다 큰 값중에 제일 왼쪽 값을 찾는다
        int res = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }

    public static void solution() {
        Arrays.sort(A, 1, N + 1);

        int v1 = 0;
        int v2 = 0;
        int best_sum = Integer.MAX_VALUE;
        for (int left = 1; left <= N - 1; left++) {
            // left를 용액으로 쓴다고 가정하고 -left와 합이 0보다 큰 수중에 가장 작은 값을 찾는다
            int candidate = lower_bound(left + 1, N, -A[left]);

            if (left < candidate - 1 && Math.abs(A[candidate - 1] + A[left]) < best_sum) {
                best_sum = Math.abs(A[candidate - 1] + A[left]);
                v1 = A[left];
                v2 = A[candidate - 1];
            }

            if (candidate <= N && Math.abs(A[candidate] + A[left]) < best_sum) {
                best_sum = Math.abs(A[candidate] + A[left]);
                v1 = A[left];
                v2 = A[candidate];
            }
        }
        sb.append(v1).append(" ").append(v2);
        System.out.println(sb);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
