package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260_list {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;


    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');

        for (int y : adj[x]) {
            if(visit[y]) continue;

            dfs(y);
        }
    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;

        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(' ');

            for (int y : adj[num]) {
                if(visit[y]) continue;
                q.add(y);
                visit[y] = true;
            }
        }
    }

    static void solution() {
        for (int i = 0; i <= N; i++) {
            Collections.sort(adj[i]);
        }
        dfs(V);
        sb.append('\n');
        for (int i = 0; i <= N; i++) {
            visit[i] = false;
        }
        bfs(V);
        System.out.println(sb);
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
