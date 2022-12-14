package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888 {
    public static BufferedReader br;
    public static StringTokenizer st;
    public static int N, minValue, maxValue;
    public static int[] A, operator;

    public static void dfs(int x, int value) {
        if (x == N) {

        } else {
            for (int i = 1; i <= 4; i++) {
                operator[i]--;

            }
        }
    }

    public static int operator(int operator1, int operator, int operator2) {
        if (operator == 1) {
            return operator1 + operator2;
        } else if (operator == 2) {
            return operator1 - operator2;
        } else if (operator == 3) {
            return operator1 * operator2;
        } else {
            return operator1 / operator2;
        }
    }

    public static void solution(int x, int value) {
        if (x == N) {
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (operator[i] > 0) {
                    operator[i]--;
                    solution(x + 1, operator(value, i, A[x + 1]));
                    operator[i]++;
                }
            }
        }
    }

    public static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        operator = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        minValue = Integer.MAX_VALUE;
        maxValue = Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws IOException {
        input();
        solution(1, A[1]);

        System.out.println(maxValue);
        System.out.println(minValue);
    }
}
