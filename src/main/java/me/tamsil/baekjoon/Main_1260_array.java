package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_array {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, V;
    static int[][] arr;
    static boolean[] visit;

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');

        for (int y = 1; y <= N; y++) {
            if(arr[x][y] == 0) continue;
            if(visit[y]) continue;

            dfs(y);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');

            for (int y = 1; y <= N; y++) {
                if(arr[x][y] ==0) continue;
                if(visit[y]) continue;

                queue.add(y);
                visit[y] = true;
            }
        }
    }

    static void solution() {
        dfs(V);
        sb.append('\n');
        for (int i = 0; i <= N; i++) {
            visit[i] = false;
        }
        bfs(V);
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = 1;
            arr[to][from] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
