package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_15970 {
    public static int N, answer;
    public static ArrayList<Integer>[] adj;

    public static int toLeft(int i, int j) {
        if (j == 0) {
            return Integer.MAX_VALUE;
        }

        return adj[i].get(j) - adj[i].get(j - 1);
    }

    public static int toRight(int i, int j) {
        if (j >= adj[i].size() - 1) {
            return Integer.MAX_VALUE;
        }
        return adj[i].get(j + 1) - adj[i].get(j);
    }

    public static void solution() {
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int leftDist = toLeft(i, j);
                int rightDist = toRight(i, j);
                answer += Math.min(leftDist, rightDist);
            }
        }
        System.out.println(answer);
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            adj[color].add(point);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
