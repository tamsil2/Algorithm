package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606 {
    private static int N, T, answer;
    private static int[][] arr;
    private static boolean[] checked;

    public static void dfs(int start) {
        answer++;
        checked[start] = true;

        for (int i = start; i < N; i++) {
            if (checked[i] == false && arr[start][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N + 1][N + 1];
        checked = new boolean[N + 1];
        answer = 0;
        int from, to;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        dfs(1);
        System.out.println(answer-1);
    }
}
