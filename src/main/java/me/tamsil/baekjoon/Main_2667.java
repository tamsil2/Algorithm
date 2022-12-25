package me.tamsil.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2667 {
    static StringBuilder sb = new StringBuilder();
    static int N, groupCnt;
    static String[] str;
    static boolean[][] visit;
    static ArrayList<Integer> groupList;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static void dfs(int x, int y) {
        groupCnt++;
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visit[nx][ny]) continue;
            if(str[nx].charAt(ny) == '0') continue;
            dfs(nx, ny);
        }
    }

    static void solution() {
        groupList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && str[i].charAt(j) == '1') {
                    groupCnt = 0;
                    dfs(i, j);
                    groupList.add(groupCnt);
                }
            }
        }

        sb.append(groupList.size()).append('\n');
        for (int group : groupList) {
            sb.append(group).append('\n');
        }
        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = new String[N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
